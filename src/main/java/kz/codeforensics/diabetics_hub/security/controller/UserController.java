package kz.codeforensics.diabetics_hub.security.controller;


import kz.codeforensics.diabetics_hub.security.models.dto.AuthenticationResponse;
import kz.codeforensics.diabetics_hub.security.models.dto.RegistrationDto;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get/{username}")
    public ResponseEntity<AuthenticationResponse> helloUserController(@PathVariable String username){
        return ResponseEntity.ok().body(userService.get(username));
    }

    @GetMapping("/get")
    public ResponseEntity<AuthenticationResponse> get(){
        return ResponseEntity.ok().body(userService.getCurrentUser());
    }

    @PutMapping("/update")
    public ResponseEntity<AuthenticationResponse> update(@RequestBody RegistrationDto registrationRequest){
        return ResponseEntity.ok().body(userService.update(registrationRequest));
    }

}
