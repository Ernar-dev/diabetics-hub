package kz.codeforensics.diabetics_hub.security.models.dto;

import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatUserDTO {
    private String fullName;
    private String email;
    private String password;
//    private RoleEnum role;
}
