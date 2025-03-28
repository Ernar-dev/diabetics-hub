package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.LipidProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LipidProfileRepository extends JpaRepository<LipidProfile, Long> {
}
