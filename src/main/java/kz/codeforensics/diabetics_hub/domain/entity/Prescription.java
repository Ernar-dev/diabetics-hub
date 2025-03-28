package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Лечение и рекомендации
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    private DoctorProfile doctorId;

//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    private Patient patientId;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "reminders_patient")
    private String remindersPatient;

    @Column(name = "created_at")
    private LocalDate createdAt;

}
