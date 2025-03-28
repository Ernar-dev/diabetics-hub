package kz.codeforensics.diabetics_hub.domain.repository;


import kz.codeforensics.diabetics_hub.domain.entity.MedicalHistoryAndComplaints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryAndComplaintsRepository extends JpaRepository<MedicalHistoryAndComplaints, Long> {
}
