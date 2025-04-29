package kz.codeforensics.diabetics_hub.domain.repository;


import kz.codeforensics.diabetics_hub.domain.entity.MedicalHistoryAndComplaints;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalHistoryAndComplaintsRepository extends JpaRepository<MedicalHistoryAndComplaints, Long> {

    Optional<MedicalHistoryAndComplaints> findByPatientId(Patient patientId);

}
