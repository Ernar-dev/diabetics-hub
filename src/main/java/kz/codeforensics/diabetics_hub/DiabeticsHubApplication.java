package kz.codeforensics.diabetics_hub;

import kz.codeforensics.diabetics_hub.domain.enums.RoleEnum;
import kz.codeforensics.diabetics_hub.security.models.Role;
import kz.codeforensics.diabetics_hub.security.models.User;
import kz.codeforensics.diabetics_hub.security.repository.RoleRepository;
import kz.codeforensics.diabetics_hub.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableScheduling
public class DiabeticsHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiabeticsHubApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByEmail("admin@admin").isEmpty()) {
				Role roleAdmin = roleRepository.findByName(RoleEnum.ADMIN).orElseThrow(() ->
						new RuntimeException("Admin role not found"));
				Set<Role> roles = new HashSet<>();
				roles.add(roleAdmin);
				User admin = new User("admin", "admin", "admin", "040223823974", "admin@admin", passwordEncoder.encode("diabeticsadmin"), roles);
				userRepository.save(admin);
			}
		};
	}

}
