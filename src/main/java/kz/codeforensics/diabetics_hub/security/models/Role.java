package kz.codeforensics.diabetics_hub.security.models;

import jakarta.persistence.*;
import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column
    private RoleEnum name;


    public Role(){
        super();
    }

    public Role(RoleEnum authority) {
        this.name = authority;
    }

    public Role(Long id, RoleEnum authority) {
        this.id = id;
        this.name = authority;
    }

    @Override
    public String getAuthority() {
        return String.valueOf(this.name);
    }

    public void setAuthority(String authority) {
        this.name = RoleEnum.valueOf(authority);
    }

    public Long getRoleId() {
        return this.id;
    }

    public void setRoleId(Long roleId) {
        this.id = roleId;
    }

}
