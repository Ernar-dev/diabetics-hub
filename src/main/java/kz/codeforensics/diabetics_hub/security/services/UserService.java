package kz.codeforensics.diabetics_hub.security.services;


import kz.codeforensics.diabetics_hub.security.models.Role;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.repository.UserRepository;
import kz.codeforensics.diabetics_hub.security.mapper.ApplcationMapper;
import kz.codeforensics.diabetics_hub.security.models.dto.AuthenticationResponse;
import kz.codeforensics.diabetics_hub.security.models.dto.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;
    private final ApplcationMapper applcationMapper;

    @Autowired
    public UserService(UserRepository userRepository, ApplcationMapper applcationMapper) {
        this.userRepository = userRepository;
        this.applcationMapper = applcationMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service");

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public AuthenticationResponse get(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return applcationMapper.mapToDto(user);
    }

    @Transactional(readOnly = true)
    public AuthenticationResponse getCurrentUser() {
        User user = getCurrentUserLogin()
                .flatMap(userRepository::findByUsername)
                .orElseThrow(() -> new RuntimeException("User could not be found"));
        return applcationMapper.mapToDto(user);
    }

    public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()));
    }

//hhhhhhhhhhhhhhhhhh
    private static String extractPrincipal(Authentication authentication) {
        if (authentication == null) {
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails springSecurityUser) {
            return springSecurityUser.getUsername();
        } else if (authentication.getPrincipal() instanceof Jwt jwt) {
            return jwt.getSubject();
        } else if (authentication.getPrincipal() instanceof String s) {
            return s;
        }
        return null;
    }

    public AuthenticationResponse update(RegistrationDto registrationRequest){
        AuthenticationResponse user = getCurrentUser();
        User appUser = userRepository.findByUsername(user.getUsername()).orElseThrow();
        if (registrationRequest.getUsername() != null) {
            appUser.setUsername(registrationRequest.getUsername());
        }
        if (registrationRequest.getPassword() != null) {
            appUser.setPassword(registrationRequest.getPassword());
        }
        userRepository.save(appUser);
        return new AuthenticationResponse(
                appUser.getUsername(),
                (Set<Role>) appUser.getRoles()
        );
    }

    public void deleteUser(String username) {
        User appUser = userRepository.findByUsername(username).orElseThrow();
        userRepository.delete(appUser);
    }

    @Transactional(readOnly = true)
    public User getUserEntity() {
        User user = getCurrentUserLogin()
                .flatMap(userRepository::findByUsername)
                .orElseThrow(() -> new RuntimeException("User could not be found"));
        return user;
    }

    @Transactional(readOnly = true)
    public User getUserIin( String iin ) {
        return userRepository.findByIin(iin).get();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}

