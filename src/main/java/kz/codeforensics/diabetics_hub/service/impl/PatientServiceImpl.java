package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.dto.PatientDto;
import kz.codeforensics.diabetics_hub.domain.entity.Patient;
import kz.codeforensics.diabetics_hub.domain.repository.PatientRepository;
import kz.codeforensics.diabetics_hub.mapper.PatientMapper;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.services.AuthenticationService;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import kz.codeforensics.diabetics_hub.service.DoctorProfileService;
import kz.codeforensics.diabetics_hub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        if (userService.getUsername(patientDto.getUser().getUsername()).isPresent()
                || userService.getIin(patientDto.getUser().getIin()).isPresent()) {
            throw new RuntimeException("Такой название пользователь уже сушествует " + patientDto.getUser().getUsername()
                    + " или такой иин уже сушествует " + patientDto.getUser().getIin());
        }
        var patient = patientMapper.mapToEntity(patientDto);
        patient.setUser(authenticationService.registerUserIsDoctor(patientDto.getUser()));
        patient.setDoctor(userService.getUserEntity());
        return patientMapper.mapToDto(patientRepository.save(patient));
    }

    @Override
    public PatientDto get() {
        return patientMapper.mapToDto(patientRepository.findByUser(userService.getUserEntity()).get());
    }

    public Patient getCurrentPatient() {
        return patientRepository.findByUser(userService.getUserEntity()).get();
    }

    public Patient getPatientUser(User user) {
        return patientRepository.findByUser(user).get();
    }

    @Override
    public PatientDto updatePatient(String iin, PatientDto patientDto) {
        Optional<Patient> optionalPatient = patientRepository.findByUser(userService.getUserIin(iin));
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            existingPatient.setFirstName(patientDto.getFirstName());
            existingPatient.setMiddleName(patientDto.getMiddleName());
            existingPatient.setLastName(patientDto.getLastName());
            existingPatient.setBirthDate(patientDto.getBirthDate());
            existingPatient.setGender(patientDto.getGender());
            existingPatient.setContactNumber(patientDto.getContactNumber());
            existingPatient.setCreateDate(patientDto.getCreateDate());
            existingPatient.setDiabetesType(patientDto.getDiabetesType());
            return patientMapper.mapToDto(patientRepository.save(existingPatient));
        }
        return null;
    }

    @Override
    public void deletePatient(String iin) {
        User user = userService.getUserIin(iin);
        patientRepository.deleteByUser(user);
    }

    @Override
    public PatientDto get(Long id) {
        return patientMapper.mapToDto(patientRepository.findById(id).get());
    }

}
