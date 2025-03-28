package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/** Планирование следующего визита */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "next_visit_planning")
public class NextVisitPlanning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Дата следующего визита */
    @Column(name = "next_visit_date")
    private LocalDate nextVisitDate;

    /** Причина следующего визита */
    @Column(name = "next_visit_reason")
    private String nextVisitReason;

}
