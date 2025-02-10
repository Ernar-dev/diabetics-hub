package kz.codeforensics.diabetics_hub.domain.entity;

import jakarta.persistence.*;
import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column
    private RoleEnum name;


    public void setId(Long id) {
        this.id = id;
    }

}
