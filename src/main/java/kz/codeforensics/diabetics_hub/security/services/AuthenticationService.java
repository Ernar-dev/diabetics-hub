package kz.codeforensics.diabetics_hub.security.services;


import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import kz.codeforensics.diabetics_hub.security.mapper.ApplcationMapper;
import kz.codeforensics.diabetics_hub.security.models.Role;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.models.dto.*;
import kz.codeforensics.diabetics_hub.security.repository.RoleRepository;
import kz.codeforensics.diabetics_hub.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
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
    private ChatIntegrationService chatIntegrationService;

    @Autowired
    public AuthenticationService(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 TokenService tokenService,
                                 UserService userService,
                                 ApplcationMapper userMapper,
                                 ChatIntegrationService chatIntegrationService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userService = userService;
        this.userMapper = userMapper;
        this.chatIntegrationService = chatIntegrationService;
    }

    public AuthenticationResponse registerUser(RegistrationDto body) {
        if (userRepository.findByUsername(body.getUsername()).isPresent() || body.getPassword().length() < 6) {
            throw new RuntimeException("Пользователь с таким именем уже существует или его пароль мала 6 букв: " + body.getUsername());
        }
        Role userRole = roleRepository.findByName(body.getRole()).get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        User user = userService.save(userMapper.mapToEntityRegistrationDto(body, authorities));
        if (userRole.getName() == RoleEnum.DOCTOR || userRole.getName() == RoleEnum.PATIENT) {
            chatIntegrationService.sendUserToChatServer(new ChatUserDTO(user.getUsername(), user.getEmail(), body.getPassword()));
        }
        var token = checkToken(body.getUsername(), body.getPassword());
        return new AuthenticationResponse(user.getUsername(), user.getFirstName(), user.getLastName(), user.getIin(), user.getEmail(), user.getRoles(), token);
    }

    public AuthenticationResponse loginUser(LoginResponseDto body) {
        var token = checkToken(body.getUsername(), body.getPassword());
        var user = userRepository.findByUsername(body.getUsername()).get();
        Role userRole = Objects.requireNonNull(getRole(user.getRoles()));
        if (userRole.getName() == RoleEnum.DOCTOR || userRole.getName() == RoleEnum.PATIENT) {
            chatIntegrationService.sendUserToChatLoginServer(new ChatUserLoginDto(user.getEmail(), body.getPassword()));
        }
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

    private Role getRole(Set<Role> roleSet) {
        for (Role role : roleSet) {
            if (role != null) {
                return role;
            }
        }
        return null;
    }

}
