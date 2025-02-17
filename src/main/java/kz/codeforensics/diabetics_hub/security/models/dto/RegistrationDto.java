package kz.codeforensics.diabetics_hub.security.models.dto;

import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private String username;
    private String firstName;
    private String lastName;
    private String iin;
    private String email;
    private String password;
    private RoleEnum role;

    @Override
    public String toString() {
        return "Registration info:" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", iin='" + iin + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password;
    }
}
