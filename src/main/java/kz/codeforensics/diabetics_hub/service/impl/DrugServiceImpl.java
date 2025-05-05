package kz.codeforensics.diabetics_hub.service.impl;

import kz.codeforensics.diabetics_hub.domain.entity.Drug;
import kz.codeforensics.diabetics_hub.domain.repository.DrugRepository;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.services.UserService;
import kz.codeforensics.diabetics_hub.service.DrugService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {

    private final DrugRepository drugRepository;
    private final UserService userService;

    public DrugServiceImpl(DrugRepository drugRepository, UserService userService) {
        this.drugRepository = drugRepository;
        this.userService = userService;
    }

    @Override
    public Drug saveMorning(String answer, Long patientId) {
        User patient = userService.findById(patientId);
        Optional<Drug> drug = drugRepository.findByPatientId(patient);
        if (drug.isEmpty()) {
            if (answer.equals("yes")) {
                return drugRepository.save(new Drug(patient, LocalDate.now(), true, false, false));
            } else {
                return drugRepository.save(new Drug(patient, LocalDate.now(), false, false, false));
            }
        } else {
            Drug resultDrug = drug.get();
            resultDrug.setCreateAt(LocalDate.now());
            if (answer.equals("yes")) {
                resultDrug.setMorning(true);
            } else {
                resultDrug.setMorning(false);
            }
            return drugRepository.save(resultDrug);
        }
    }

    @Override
    public Drug saveNoon(String answer, Long patientId) {
        User patient = userService.findById(patientId);
        Drug drug = drugRepository.findByPatientId(patient).get();
        drug.setCreateAt(LocalDate.now());
        if (answer.equals("yes")) {
            drug.setNoon(true);
        } else {
            drug.setNoon(false);
        }
        return drugRepository.save(drug);
    }

    @Override
    public Drug saveNight(String answer, Long patientId) {
        User patient = userService.findById(patientId);
        Drug drug = drugRepository.findByPatientId(patient).get();
        drug.setCreateAt(LocalDate.now());
        if (answer.equals("yes")) {
            drug.setNight(true);
        } else {
            drug.setNight(false);
        }
        return drugRepository.save(drug);
    }
}
