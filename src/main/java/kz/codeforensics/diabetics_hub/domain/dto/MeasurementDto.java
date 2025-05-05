package kz.codeforensics.diabetics_hub.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MeasurementDto {

    @JsonIgnore
    private Patient patient;

    private Float glucoseLevel;

    private Float weight;

    private String bloodPressure;

    @JsonIgnore
    private LocalDate createDate;

}
