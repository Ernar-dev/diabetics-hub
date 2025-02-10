package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {

    PatientHistory getByRegistrationNumber(Long registrationNumber);

    Void deleteByRegistrationNumber(Long registrationNumber);

}
