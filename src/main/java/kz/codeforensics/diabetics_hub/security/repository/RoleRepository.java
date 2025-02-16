package kz.codeforensics.diabetics_hub.security.repository;

import kz.codeforensics.diabetics_hub.security.models.Role;
import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleEnum authority);

}
