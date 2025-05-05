package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import kz.codeforensics.diabetics_hub.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/***
 * Лекарство
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patientId;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "morning")
    private Boolean morning;

    @Column(name = "noon")
    private Boolean noon;

    @Column(name = "night")
    private Boolean night;

    public Drug(User patientId, LocalDate createAt, Boolean morning, Boolean noon, Boolean night) {
        this.patientId = patientId;
        this.createAt = createAt;
        this.morning = morning;
        this.noon = noon;
        this.night = night;
    }
}
