package kz.codeforensics.diabetics_hub.domain.dto;

import kz.codeforensics.diabetics_hub.domain.enums.DiabetesTypeEnum;
import kz.codeforensics.diabetics_hub.domain.enums.GenderEnum;
import kz.codeforensics.diabetics_hub.security.models.dto.RegistrationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;

    private RegistrationDto user;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;

    private GenderEnum gender;

    private String contactNumber;

    private LocalDate createDate;

    private DiabetesTypeEnum DiabetesType;

}
