package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.NextVisitPlanning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NextVisitPlanningRepository extends JpaRepository<NextVisitPlanning, Long> {
}
