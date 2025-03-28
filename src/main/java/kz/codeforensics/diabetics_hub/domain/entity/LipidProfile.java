package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Липидный профиль
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lipid_profile")
public class LipidProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Общий холестерин (ммоль/л) */
    @Column(name = "total_cholesterol")
    private Float totalCholesterol;

    /** ЛПНП (ммоль/л) */
    @Column(name = "ldl_cholesterol")
    private Float ldlCholesterol;

    /** ЛПВП (ммоль/л) */
    @Column(name = "hdl_cholesterol")
    private Float hdlCholesterol;

    /** Триглицериды (ммоль/л) */
    @Column(name = "triglycerides")
    private Float triglycerides;

}
