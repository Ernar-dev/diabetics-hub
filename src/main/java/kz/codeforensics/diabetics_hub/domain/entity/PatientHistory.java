package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import kz.codeforensics.diabetics_hub.domain.enums.*;
import kz.codeforensics.diabetics_hub.security.models.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient_history")
public class PatientHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_number", unique = true, nullable = false)
    private Long registrationNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "age")
    private Long age;

    @Column(name = "iin")
    private String iin;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;

    @Column(name = "heart_problems")
    private Boolean heartProblems;

    @Column(name = "chest_pain")
    private Boolean chestPain;

    @Column(name = "diabetes")
    private Boolean diabetes;

    @Column(name = "asthma")
    private Boolean asthma;

    @Column(name = "hypertension")
    private Boolean hypertension;

    @Column(name = "taking_medications")
    private Boolean takingMedications;

    @Column(name = "allergies_have")
    private Boolean allergiesHave;

    @Column(name = "operations")
    private Boolean operations;

    @Column(name = "hereditary_diseases")
    private Boolean hereditaryDiseases;

    @Column(name = "hereditary_diabetes")
    private Boolean hereditaryDiabetes;

    @Enumerated(EnumType.STRING)
    @Column(name = "smoking")
    private SmokingEnum smoking;

    @Enumerated(EnumType.STRING)
    @Column(name = "drinking_alcohol")
    private DrinkingAlcoholEnum drinkingAlcohol;

    @Enumerated(EnumType.STRING)
    @Column(name = "often_play_sports")
    private OftenPlaySportsEnum oftenPlaySports;

    @Enumerated(EnumType.STRING)
    @Column(name = "food_type")
    private FoodTypeEnum foodType;

    @Enumerated(EnumType.STRING)
    @Column(name = "how_often_do_eat")
    private HowOftenDoEatEnum howOftenDoEat;

    @Column(name = "mood_disorder")
    private Boolean moodDisorder;

    @Enumerated(EnumType.STRING)
    @Column(name = "psycho_emotional_state")
    private PsychoEmotionalStateEnum psychoEmotionalState;

    @Column(name = "psychotropic_drugs")
    private Boolean psychotropicDrugs;

}
