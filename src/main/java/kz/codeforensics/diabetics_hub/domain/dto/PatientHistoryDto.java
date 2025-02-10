package kz.codeforensics.diabetics_hub.domain.dto;

import kz.codeforensics.diabetics_hub.domain.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientHistoryDto {

    private Long registrationNumber;

    private Long age;

    private GenderEnum gender;

    private Boolean heartProblems;

    private Boolean chestPain;

    private Boolean diabetes;

    private Boolean asthma;

    private Boolean hypertension;

    private Boolean takingMedications;

    private Boolean allergiesHave;

    private Boolean operations;

    private Boolean hereditaryDiseases;

    private Boolean hereditaryDiabetes;

    private SmokingEnum smoking;

    private DrinkingAlcoholEnum drinkingAlcohol;

    private OftenPlaySportsEnum oftenPlaySports;

    private FoodTypeEnum foodType;

    private HowOftenDoEatEnum howOftenDoEat;

    private Boolean moodDisorder;

    private PsychoEmotionalStateEnum psychoEmotionalState;

    private Boolean psychotropicDrugs;

}
