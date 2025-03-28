package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import kz.codeforensics.diabetics_hub.domain.enums.DiabetesTypeEnum;
import kz.codeforensics.diabetics_hub.domain.enums.GenderEnum;
import kz.codeforensics.diabetics_hub.security.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "diabetes_type")
    private DiabetesTypeEnum diabetesType;

}
