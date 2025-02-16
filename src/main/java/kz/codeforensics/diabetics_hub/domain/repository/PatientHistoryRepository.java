package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.PatientHistory;
import kz.codeforensics.diabetics_hub.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {

    PatientHistory findByRegistrationNumber(Long registrationNumber);

    Void deleteByRegistrationNumber(Long registrationNumber);

    PatientHistory findByUser(User user);

}
