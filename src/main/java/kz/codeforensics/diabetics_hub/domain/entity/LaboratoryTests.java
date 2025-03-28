package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Лабораторные исследования
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laboratory_tests")
public class LaboratoryTests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Глюкоза натощак (ммоль/л) */
    @Column(name = "fasting_glucose")
    private Float fastingGlucose;

    /** HbA1c (%) */
    @Column(name = "hbA1c")
    private Float hbA1c;

    /** Липидный профиль */
    @OneToOne
    @JoinColumn(name = "lipid_profile_id")
    private LipidProfile lipidProfileId;

    /** Креатинин (мкмоль/л) */
    @Column(name = "creatinine")
    private Long creatinine;

    /** Альбуминурия (мг/л) */
    @Column(name = "albuminuria")
    private Long albuminuria;

}
