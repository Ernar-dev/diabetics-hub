package kz.codeforensics.diabetics_hub.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LipidProfileDto {

    /** Общий холестерин (ммоль/л) */
    private Float totalCholesterol;

    /** ЛПНП (ммоль/л) */
    private Float ldlCholesterol;

    /** ЛПВП (ммоль/л) */
    private Float hdlCholesterol;

    /** Триглицериды (ммоль/л) */
    private Float triglycerides;

}
