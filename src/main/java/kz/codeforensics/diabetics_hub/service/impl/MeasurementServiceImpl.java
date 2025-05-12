package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.dto.GlucoseMonitoringDto;
import kz.codeforensics.diabetics_hub.domain.dto.MeasurementDto;
import kz.codeforensics.diabetics_hub.domain.entity.Measurement;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import kz.codeforensics.diabetics_hub.domain.repository.MeasurementRepository;
import kz.codeforensics.diabetics_hub.domain.repository.PatientRepository;
import kz.codeforensics.diabetics_hub.mapper.MeasurementMapper;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import kz.codeforensics.diabetics_hub.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;
    private final UserService userService;
    private final PatientRepository patientRepository;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository, MeasurementMapper measurementMapper, UserService userService, PatientRepository patientRepository) {
        this.measurementRepository = measurementRepository;
        this.measurementMapper = measurementMapper;
        this.userService = userService;
        this.patientRepository = patientRepository;
    }

    @Transactional
    @Override
    public MeasurementDto create(MeasurementDto measurementDto) {
        var entity = measurementMapper.mapToEntity(measurementDto);
        User user = userService.getUserEntity();
        Patient patient = patientRepository.findByUser(user).get();
        entity.setPatient(patient);
        entity.setCreateDate(LocalDate.now());
        return measurementMapper.mapToDto(measurementRepository.save(entity));
    }

    @Override
    public Page<MeasurementDto> getAll(Pageable pageable, String iin) {
        return this.getMeasurement(pageable, iin).map(measurementMapper::mapToDto);
    }

    @Override
    public Page<GlucoseMonitoringDto> getGlucoseMonitoring(Pageable pageable, String iin) {
        return this.getMeasurement(pageable, iin).map(measurementMapper::mapToGlucoseMonitoringDto);
    }

    private Page<Measurement> getMeasurement(Pageable pageable, String iin) {
        var patient = patientRepository.findByUser(userService.getUserIin(iin)).get();
        List<Measurement> allMeasurements = measurementRepository.findAllByPatient(patient);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), allMeasurements.size());
        List<Measurement> pageContent = allMeasurements.subList(start, end);
        return new PageImpl<>(pageContent, pageable, allMeasurements.size());
    }

}
