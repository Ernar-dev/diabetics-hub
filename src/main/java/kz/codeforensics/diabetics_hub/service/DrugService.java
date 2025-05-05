package kz.codeforensics.diabetics_hub.service;

import kz.codeforensics.diabetics_hub.domain.entity.Drug;

public interface DrugService {

    Drug saveMorning(String answer, Long patientId);

    Drug saveNoon(String answer, Long patientId);

    Drug saveNight(String answer, Long patientId);

}
