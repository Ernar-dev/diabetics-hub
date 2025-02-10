package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.dto.PatientHistoryDto;
import kz.codeforensics.diabetics_hub.domain.entity.PatientHistory;
import kz.codeforensics.diabetics_hub.domain.repository.PatientHistoryRepository;
import kz.codeforensics.diabetics_hub.mapper.PatientHistoryMapper;
import kz.codeforensics.diabetics_hub.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private final PatientHistoryRepository patientHistoryRepository;
    private final PatientHistoryMapper patientHistoryMapper;

    @Autowired
    public PatientHistoryServiceImpl(PatientHistoryRepository patientHistoryRepository, PatientHistoryMapper patientHistoryMapper) {
        this.patientHistoryRepository = patientHistoryRepository;
        this.patientHistoryMapper = patientHistoryMapper;
    }


    @Override
    public PatientHistoryDto create(PatientHistoryDto patientHistoryDto) {
        var entity = patientHistoryMapper.mapToEntity(patientHistoryDto);
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
        PatientHistory entity = patientHistoryRepository.getByRegistrationNumber(patientHistoryDto.getRegistrationNumber());
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
        return patientHistoryMapper.mapToDto(patientHistoryRepository.getByRegistrationNumber(registrationNumber));
    }

    @Override
    public Void deleteRegistrationNumber(Long registrationNumber) {
        return patientHistoryRepository.deleteByRegistrationNumber(registrationNumber);
    }


}
