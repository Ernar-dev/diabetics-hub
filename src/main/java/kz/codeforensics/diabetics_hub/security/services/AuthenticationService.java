package kz.codeforensics.diabetics_hub.security.services;


import kz.codeforensics.diabetics_hub.security.mapper.ApplcationMapper;
import kz.codeforensics.diabetics_hub.security.models.Role;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.repository.RoleRepository;
import kz.codeforensics.diabetics_hub.security.repository.UserRepository;
import kz.codeforensics.diabetics_hub.security.models.dto.AuthenticationResponse;
import kz.codeforensics.diabetics_hub.security.models.dto.LoginResponseDto;
import kz.codeforensics.diabetics_hub.security.models.dto.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;
    private UserService userService;
    private ApplcationMapper userMapper;

    @Autowired
    public AuthenticationService(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 TokenService tokenService,
                                 UserService userService, ApplcationMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public AuthenticationResponse registerUser(RegistrationDto body){
        Role userRole = roleRepository.findByName(body.getRole()).get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        User user = userService.save(userMapper.mapToEntityRegistrationDto(body, authorities));
        var token = checkToken(body.getUsername(), body.getPassword());
        return new AuthenticationResponse(user.getUsername(), user.getFirstName(), user.getLastName(), user.getIin(), user.getEmail(), user.getRoles(), token);
    }

    public AuthenticationResponse loginUser(LoginResponseDto body) {
        var token = checkToken(body.getUsername(), body.getPassword());
        var user = userRepository.findByUsername(body.getUsername()).get();
        return new AuthenticationResponse(user.getUsername(), user.getFirstName(), user.getLastName(), user.getIin(), user.getEmail(), user.getRoles(), token);
    }

    private String checkToken(String username, String password) {

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            return tokenService.generateJwt(auth);

        } catch(AuthenticationException e){
            return null;
        }
    }

    public User registerUserIsDoctor(RegistrationDto registrationDto) {
        Role userRole = roleRepository.findByName(registrationDto.getRole()).get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        User user = userService.save(userMapper.mapToEntityRegistrationDto(registrationDto, authorities));
        return user;
    }

}
