package kz.codeforensics.diabetics_hub.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GlucoseMonitoringDto {

    private Float glucoseLevel;

    private LocalDate createDate;

}
