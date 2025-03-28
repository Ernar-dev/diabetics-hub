package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.PhysicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicalExaminationRepository extends JpaRepository<PhysicalExamination, Long> {
}
