package kz.codeforensics.diabetics_hub.domain.repository;

import kz.codeforensics.diabetics_hub.domain.entity.Measurement;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

//    @Query("SELECT m FROM measurement m WHERE m.patient.id = :patientId")
//    Page<Measurement> findByPatient(@Param("patientId") Long patientId, Pageable pageable);

    List<Measurement> findAllByPatient(Patient patient);

}
