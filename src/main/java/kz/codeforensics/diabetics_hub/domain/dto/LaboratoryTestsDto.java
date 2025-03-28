package kz.codeforensics.diabetics_hub.domain.dto;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaboratoryTestsDto {

    /** Глюкоза натощак (ммоль/л) */
    private Float fastingGlucose;

    /** HbA1c (%) */
    private Float hbA1c;

    /** Липидный профиль */
    @OneToOne
    private LipidProfileDto lipidProfileId;

    /** Креатинин (мкмоль/л) */
    private Long creatinine;

    /** Альбуминурия (мг/л) */
    private Long albuminuria;

}
