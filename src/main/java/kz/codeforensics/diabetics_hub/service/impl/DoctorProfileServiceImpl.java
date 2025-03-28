package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.dto.DoctorProfileDto;
import kz.codeforensics.diabetics_hub.domain.entity.DoctorProfile;
import kz.codeforensics.diabetics_hub.domain.repository.DoctorProfileRepository;
import kz.codeforensics.diabetics_hub.mapper.DoctorProfileMapper;
import kz.codeforensics.diabetics_hub.service.DoctorProfileService;
import org.springframework.stereotype.Service;

@Service
public class DoctorProfileServiceImpl implements DoctorProfileService {

    private final DoctorProfileRepository doctorProfileRepository;
    private final DoctorProfileMapper doctorProfileMapper;

    public DoctorProfileServiceImpl(DoctorProfileRepository doctorProfileRepository, DoctorProfileMapper doctorProfileMapper) {
        this.doctorProfileRepository = doctorProfileRepository;
        this.doctorProfileMapper = doctorProfileMapper;
    }

    @Override
    public DoctorProfileDto create(DoctorProfileDto doctorProfileDto) {
        DoctorProfile entity = doctorProfileRepository.save(doctorProfileMapper.mapToEntity(doctorProfileDto));
        return doctorProfileMapper.mapToDto(entity);
    }

//    @Override
//    public DoctorProfile save(DoctorProfile doctorProfile) {
//        return doctorProfileRepository.save(doctorProfile);
//    }
}
