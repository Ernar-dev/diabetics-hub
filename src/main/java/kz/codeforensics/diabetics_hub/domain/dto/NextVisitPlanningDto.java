package kz.codeforensics.diabetics_hub.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NextVisitPlanningDto {

    /** Дата следующего визита */
    private LocalDate nextVisitDate;

    /** Причина следующего визита */
    private String nextVisitReason;

}
