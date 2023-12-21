package edu.bbte.idde.bfim2114.hexagonal;


import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.jpaentity.HardwarePartJpaEntity;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.jpaentity.UserJpaEntity;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.repository.HardwareRepository;
import edu.bbte.idde.bfim2114.hexagonal.adapter.out.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataGenerator {

    @Bean
    CommandLineRunner initDb(HardwareRepository hardwareRepository, UserRepository userRepository) {
        return ags -> {
            UserJpaEntity admin = userRepository.save(new UserJpaEntity("admin", "admin"));
            UserJpaEntity userJpaEntity = userRepository.save(new UserJpaEntity("userJpaEntity", "userJpaEntity"));

            hardwareRepository.save(new HardwarePartJpaEntity("CPU", "Intel", "i7-9700K", 8.0, "asd", userJpaEntity));
            hardwareRepository.save(new HardwarePartJpaEntity("GPU", "Nvidia", "RTX 2080", 8.0, "asd", userJpaEntity));
            hardwareRepository.save(new HardwarePartJpaEntity("RAM", "Corsair", "Vengeance LPX", 16.0, "asd", userJpaEntity));
            hardwareRepository.save(new HardwarePartJpaEntity("Motherboard", "Asus", "ROG Strix Z390-E", 8.0, "asd", admin));
        };
    }
}
