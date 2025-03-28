package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.DoctorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorProfileRepository extends JpaRepository<DoctorProfile, Long> {
}
