package kz.codeforensics.diabetics_hub.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PrescriptionDto {

    private String medicine;

    private String dosage;

    private String remindersPatient;

    private LocalDate createdAt;
}
