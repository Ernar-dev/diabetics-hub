package kz.codeforensics.diabetics_hub.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhysicalExaminationDto {

    private String height;

    private String weight;

    private Float bloodPressure;

    private Long pulseRate;

    private Float bodyTemperature;

}
