package kz.codeforensics.diabetics_hub.security.models.dto;

import kz.codeforensics.diabetics_hub.security.models.Role;
import lombok.Data;

import java.util.Set;


@Data
public class AuthenticationResponse {

    String username;
    String firstName;
    String lastName;
    String iin;
    String email;
    Set<Role> authorities;
    String jwtToken;

    public AuthenticationResponse(){};

    public AuthenticationResponse(String username, String firstName, String lastName, String iin, String email, Set<Role> authorities, String token) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.iin = iin;
        this.email = email;
        this.authorities = authorities;
        this.jwtToken = token;
    }

    public AuthenticationResponse(String username, Set<Role> authorities) {
        this.username = username;
        this.authorities = authorities;
    }
}
