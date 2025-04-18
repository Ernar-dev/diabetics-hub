package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * История болезни и жалобы
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medical_history_and_complaints")
public class MedicalHistoryAndComplaints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patientId;

    /** Дата последнего визита */
    @Column(name = "created_at")
    private LocalDate createdAt;

    /** Основные жалобы пациента */
    @Column(name = "main_complaints")
    private String mainComplaints;

    /** Сопутствующие заболевания */
    @Column(name = "comorbidities")
    private String comorbidities;

    /** Аллергии */
    @Column(name = "allergies")
    private String allergies;

    /** Физикальный осмотр */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physical_examination_id")
    private PhysicalExamination physicalExaminationId;

    /** Лабораторные исследования */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laboratory_tests_id")
    private LaboratoryTests laboratoryTestsId;

    /** Лечение и рекомендации */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id")
    private Prescription prescriptionId;

    /** Планирование следующего визита */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "next_visit_planning_id")
    private NextVisitPlanning nextVisitPlanningId;

}
