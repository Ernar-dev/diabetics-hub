package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.dto.MedicalHistoryAndComplaintsDto;
import kz.codeforensics.diabetics_hub.domain.repository.MedicalHistoryAndComplaintsRepository;
import kz.codeforensics.diabetics_hub.mapper.MedicalHistoryAndComplaintsMapper;
import kz.codeforensics.diabetics_hub.service.MedicalHistoryAndComplaintsService;
import kz.codeforensics.diabetics_hub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryAndComplaintsServiceImpl implements MedicalHistoryAndComplaintsService {

    private final MedicalHistoryAndComplaintsRepository repository;
    private final MedicalHistoryAndComplaintsMapper mapper;
    private final PatientService patientService;

    @Autowired
    public MedicalHistoryAndComplaintsServiceImpl(MedicalHistoryAndComplaintsRepository repository, MedicalHistoryAndComplaintsMapper mapper, PatientService patientService) {
        this.repository = repository;
        this.mapper = mapper;
        this.patientService = patientService;
    }

    @Override
    public MedicalHistoryAndComplaintsDto create(MedicalHistoryAndComplaintsDto dto) {
        var entity = mapper.mapToEntity(dto);
        entity.setPatientId(patientService.getCurrentPatient());
        MedicalHistoryAndComplaintsDto resultDto = mapper.mapToDto(repository.save(entity));
        return resultDto;
    }
}
