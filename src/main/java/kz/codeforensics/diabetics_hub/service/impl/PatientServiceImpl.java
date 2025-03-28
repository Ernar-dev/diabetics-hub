package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.dto.PatientDto;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import kz.codeforensics.diabetics_hub.domain.repository.PatientRepository;
import kz.codeforensics.diabetics_hub.mapper.PatientMapper;
import kz.codeforensics.diabetics_hub.security.services.AuthenticationService;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import kz.codeforensics.diabetics_hub.service.DoctorProfileService;
import kz.codeforensics.diabetics_hub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final DoctorProfileService doctorProfileService;


    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper, UserService userService, AuthenticationService authenticationService, DoctorProfileService doctorProfileService) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.doctorProfileService = doctorProfileService;
    }

    @Override
    public PatientDto create(PatientDto patientDto) {
        var patient = patientMapper.mapToEntity(patientDto);
        patient.setUser(authenticationService.registerUserIsDoctor(patientDto.getUser()));
        patient.setDoctor(userService.getUserEntity());
        return patientMapper.mapToDto(patientRepository.save(patient));
    }

    @Override
    public PatientDto get() {
        return patientMapper.mapToDto(patientRepository.findByUser(userService.getUserEntity()));
    }

    public Patient getCurrentPatient() {
        return patientRepository.findByUser(userService.getUserEntity());
    }

}
