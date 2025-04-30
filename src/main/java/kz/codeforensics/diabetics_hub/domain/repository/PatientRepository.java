package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.dto.PatientDto;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.models.dto.AuthenticationResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUser(User user);

    void deleteByUser(User user);
}
