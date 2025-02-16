package kz.codeforensics.diabetics_hub.security.controller;

import kz.codeforensics.diabetics_hub.security.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public String helloAdminController() {
        return "Admin access level";
    }

    @DeleteMapping("/delete/{username}")
    public String deletUser(@PathVariable String username){
        userService.deleteUser(username);
        return "User deleted";
    }

}
