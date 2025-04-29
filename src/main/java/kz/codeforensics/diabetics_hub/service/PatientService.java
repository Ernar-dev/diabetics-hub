package kz.codeforensics.diabetics_hub.service;

import kz.codeforensics.diabetics_hub.domain.dto.PatientDto;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;

public interface PatientService {

    PatientDto create(PatientDto patientDto);

    PatientDto get();

    Patient getCurrentPatient();

    PatientDto updatePatient(Long id, PatientDto patientDto);

    void deletePatient(Long id);

}
