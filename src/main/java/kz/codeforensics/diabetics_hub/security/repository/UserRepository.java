package kz.codeforensics.diabetics_hub.security.repository;

import kz.codeforensics.diabetics_hub.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String email);

    Optional<User> findByIin(String iin);

}
