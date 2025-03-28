package kz.codeforensics.diabetics_hub.domain.dto;

import kz.codeforensics.diabetics_hub.security.models.dto.AuthenticationResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorProfileDto {

    private AuthenticationResponse user;

    private String name;

    private String specialty;

}
