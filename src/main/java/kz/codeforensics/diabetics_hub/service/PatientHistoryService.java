package kz.codeforensics.diabetics_hub.service;

import kz.codeforensics.diabetics_hub.domain.dto.PatientHistoryDto;
import kz.codeforensics.diabetics_hub.domain.entity.PatientHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface PatientHistoryService {

    PatientHistoryDto create(PatientHistoryDto patientHistoryDto);

    Page<PatientHistory> getAll(Pageable pageable);

    PatientHistoryDto update(PatientHistoryDto patientHistoryDto);

    PatientHistoryDto getRegistrationNumber(Long registrationNumber);

    Void deleteRegistrationNumber(Long registrationNumber);

    PatientHistoryDto getUserId();
}
