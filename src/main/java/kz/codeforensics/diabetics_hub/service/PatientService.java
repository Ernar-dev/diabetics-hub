package kz.codeforensics.diabetics_hub.service;

import kz.codeforensics.diabetics_hub.domain.dto.PatientDto;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import kz.codeforensics.diabetics_hub.security.models.User;

public interface PatientService {

    PatientDto create(PatientDto patientDto);

    PatientDto get();

    Patient getCurrentPatient();

    Patient getPatientUser(User user);

    PatientDto updatePatient(String iin, PatientDto patientDto);

    void deletePatient(String iin);

    PatientDto get(Long id);
}
