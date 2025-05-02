package kz.codeforensics.diabetics_hub.service;

import kz.codeforensics.diabetics_hub.domain.dto.MedicalHistoryAndComplaintsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicalHistoryAndComplaintsService {
    MedicalHistoryAndComplaintsDto create(MedicalHistoryAndComplaintsDto dto);

    MedicalHistoryAndComplaintsDto getMedicalHistoryAndComplaints();

    Page<MedicalHistoryAndComplaintsDto> getAll(Pageable pageable);

    MedicalHistoryAndComplaintsDto update(Long id, MedicalHistoryAndComplaintsDto dto);

    void delete(Long id);

    MedicalHistoryAndComplaintsDto getId(Long id);
}
