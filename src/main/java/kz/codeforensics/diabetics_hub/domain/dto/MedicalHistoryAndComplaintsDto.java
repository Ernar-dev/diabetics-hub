package kz.codeforensics.diabetics_hub.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MedicalHistoryAndComplaintsDto {

    private Long id;

    private LocalDate createdAt;

    /** Основные жалобы пациента */
    private String mainComplaints;

    /** Сопутствующие заболевания */
    private String comorbidities;

    /** Аллергии */
    private String allergies;

    /** Физикальный осмотр */
    private PhysicalExaminationDto physicalExaminationId;

    /** Лабораторные исследования */
    private LaboratoryTestsDto laboratoryTestsId;

    /** Лечение и рекомендации */
    private PrescriptionDto prescriptionId;

    /** Планирование следующего визита */
    private NextVisitPlanningDto nextVisitPlanningId;

}
