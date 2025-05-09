package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.dto.MedicalHistoryAndComplaintsDto;
import kz.codeforensics.diabetics_hub.domain.entity.MedicalHistoryAndComplaints;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import kz.codeforensics.diabetics_hub.domain.repository.MedicalHistoryAndComplaintsRepository;
import kz.codeforensics.diabetics_hub.mapper.MedicalHistoryAndComplaintsMapper;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import kz.codeforensics.diabetics_hub.service.MedicalHistoryAndComplaintsService;
import kz.codeforensics.diabetics_hub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MedicalHistoryAndComplaintsServiceImpl implements MedicalHistoryAndComplaintsService {

    private final MedicalHistoryAndComplaintsRepository repository;
    private final MedicalHistoryAndComplaintsMapper mapper;
    private final PatientService patientService;
    private final UserService userService;

    @Autowired
    public MedicalHistoryAndComplaintsServiceImpl(MedicalHistoryAndComplaintsRepository repository,
                                                  MedicalHistoryAndComplaintsMapper mapper,
                                                  PatientService patientService,
                                                  UserService userService) {
        this.repository = repository;
        this.mapper = mapper;
        this.patientService = patientService;
        this.userService = userService;
    }

    @Override
    public MedicalHistoryAndComplaintsDto create(MedicalHistoryAndComplaintsDto dto) {
        var entity = mapper.mapToEntity(dto);
        entity.setPatientId(patientService.getPatientUser(userService.getUserIin(dto.getIin())));
        entity.setCreatedAt(LocalDate.now());
        MedicalHistoryAndComplaintsDto resultDto = mapper.mapToDto(repository.save(entity));
        return resultDto;
    }

    @Override
    public MedicalHistoryAndComplaintsDto getMedicalHistoryAndComplaints() {
        Patient patient = patientService.getCurrentPatient();
        MedicalHistoryAndComplaints entity = repository.findByPatientId(patient).get();
        return mapper.mapToDto(entity);
    }

    @Override
    public Page<MedicalHistoryAndComplaintsDto> getAll(Pageable pageable) {
        Page<MedicalHistoryAndComplaints> entity = repository.findAll(pageable);
        return entity.map(mapper::mapToDto);
    }

    @Override
    public MedicalHistoryAndComplaintsDto update(Long id, MedicalHistoryAndComplaintsDto dto) {
        MedicalHistoryAndComplaints entity = mapper.mapToEntity(dto);
        Optional<MedicalHistoryAndComplaints> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            MedicalHistoryAndComplaints existsEntity = optionalEntity.get();
            existsEntity.setCreatedAt(entity.getCreatedAt());
            existsEntity.setMainComplaints(entity.getMainComplaints());
            existsEntity.setComorbidities(entity.getComorbidities());
            existsEntity.setAllergies(entity.getAllergies());
            existsEntity.setPhysicalExaminationId(entity.getPhysicalExaminationId());
            existsEntity.setLaboratoryTestsId(entity.getLaboratoryTestsId());
            existsEntity.setPrescriptionId(entity.getPrescriptionId());
            existsEntity.setNextVisitPlanningId(entity.getNextVisitPlanningId());
            return mapper.mapToDto(repository.save(existsEntity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MedicalHistoryAndComplaintsDto getId(Long id) {
        return mapper.mapToDto(repository.findById(id).get());
    }
}
