package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.LaboratoryTests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryTestsRepository extends JpaRepository<LaboratoryTests, Long> {
}
