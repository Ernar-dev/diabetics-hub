package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.dto.PatientHistoryDto;
import kz.codeforensics.diabetics_hub.domain.entity.PatientHistory;
import kz.codeforensics.diabetics_hub.domain.repository.PatientHistoryRepository;
import kz.codeforensics.diabetics_hub.mapper.PatientHistoryMapper;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.repository.UserRepository;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import kz.codeforensics.diabetics_hub.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private final PatientHistoryRepository patientHistoryRepository;
    private final PatientHistoryMapper patientHistoryMapper;
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public PatientHistoryServiceImpl(PatientHistoryRepository patientHistoryRepository, PatientHistoryMapper patientHistoryMapper, UserService userService, UserRepository userRepository) {
        this.patientHistoryRepository = patientHistoryRepository;
        this.patientHistoryMapper = patientHistoryMapper;
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @Override
    public PatientHistoryDto create(PatientHistoryDto patientHistoryDto) {
        var entity = patientHistoryMapper.mapToEntity(patientHistoryDto);
        User user = userRepository.findByIin(patientHistoryDto.getIin()).get();
        entity.setUser(user);
        patientHistoryRepository.save(entity);
        return patientHistoryMapper.mapToDto(entity);
    }

    @Override
    public Page<PatientHistory> getAll(Pageable pageable) {

        return patientHistoryRepository.findAll(pageable);
    }

    @Override
    public PatientHistoryDto update(PatientHistoryDto patientHistoryDto) {

        if (patientHistoryDto == null){
            throw new RuntimeException("PatientHistory is null");
        }
        PatientHistory entity = patientHistoryRepository.findByRegistrationNumber(patientHistoryDto.getRegistrationNumber());
        entity.setAge(patientHistoryDto.getAge());
        entity.setGender(patientHistoryDto.getGender());
        entity.setHeartProblems(patientHistoryDto.getHeartProblems());
        entity.setChestPain(patientHistoryDto.getChestPain());
        entity.setDiabetes(patientHistoryDto.getDiabetes());
        entity.setAsthma(patientHistoryDto.getAsthma());
        entity.setHypertension(patientHistoryDto.getHypertension());
        entity.setTakingMedications(patientHistoryDto.getTakingMedications());
        entity.setAllergiesHave(patientHistoryDto.getAllergiesHave());
        entity.setOperations(patientHistoryDto.getOperations());
        entity.setHereditaryDiseases(patientHistoryDto.getHereditaryDiseases());
        entity.setHereditaryDiabetes(patientHistoryDto.getHereditaryDiabetes());
        entity.setSmoking(patientHistoryDto.getSmoking());
        entity.setDrinkingAlcohol(patientHistoryDto.getDrinkingAlcohol());
        entity.setOftenPlaySports(patientHistoryDto.getOftenPlaySports());
        entity.setFoodType(patientHistoryDto.getFoodType());
        entity.setHowOftenDoEat(patientHistoryDto.getHowOftenDoEat());
        entity.setMoodDisorder(patientHistoryDto.getMoodDisorder());
        entity.setPsychoEmotionalState(patientHistoryDto.getPsychoEmotionalState());
        entity.setPsychotropicDrugs(patientHistoryDto.getPsychotropicDrugs());
        patientHistoryRepository.save(entity);
        return patientHistoryMapper.mapToDto(entity);
    }

    @Override
    public PatientHistoryDto getRegistrationNumber(Long registrationNumber) {
        return patientHistoryMapper.mapToDto(patientHistoryRepository.findByRegistrationNumber(registrationNumber));
    }

    @Transactional
    @Override
    public Void deleteRegistrationNumber(Long registrationNumber) {
        patientHistoryRepository.deleteByRegistrationNumber(registrationNumber);
        return null;
    }

    @Override
    public PatientHistoryDto getUserId() {
        User user = userService.getCurrentUserLogin()
                .flatMap(userRepository::findByUsername)
                .orElseThrow(() -> new RuntimeException("User could not be found"));
        var result = patientHistoryRepository.findByUser(user);
        return patientHistoryMapper.mapToDto(result);
    }


}
