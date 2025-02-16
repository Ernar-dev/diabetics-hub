package kz.codeforensics.diabetics_hub.security.controller;


import kz.codeforensics.diabetics_hub.security.models.dto.AuthenticationResponse;
import kz.codeforensics.diabetics_hub.security.models.dto.LoginResponseDto;
import kz.codeforensics.diabetics_hub.security.models.dto.RegistrationDto;
import kz.codeforensics.diabetics_hub.security.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthenticationResponse registerUser(@RequestBody RegistrationDto body){
        return authenticationService.registerUser(body);
    }

    @PostMapping("/login")
    public AuthenticationResponse loginUser(@RequestBody LoginResponseDto body){
        return authenticationService.loginUser(body);
    }
}
