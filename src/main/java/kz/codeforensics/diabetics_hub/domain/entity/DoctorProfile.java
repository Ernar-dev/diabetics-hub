package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import kz.codeforensics.diabetics_hub.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor_profile")
public class DoctorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "name")
    private String name;

    @Column(name = "specialty")
    private String specialty;

}
