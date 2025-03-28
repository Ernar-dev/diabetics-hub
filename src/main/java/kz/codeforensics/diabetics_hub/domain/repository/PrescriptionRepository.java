package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
