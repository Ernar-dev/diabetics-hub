package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Физикальный осмотр
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "physical_examination")
public class PhysicalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Рост  */
    @Column(name = "height")
    private String height;

    /** Вес  */
    @Column(name = "weight")
    private String weight;

    /** Артериальное давление (мм рт. ст.) */
    @Column(name = "blood_pressure")
    private Float bloodPressure;

    /** Пульс (уд./мин) */
    @Column(name = "pulse_rate")
    private Long pulseRate;

    /** Температура тела (°C) */
    @Column(name = "body_temperature")
    private Float bodyTemperature;

}
