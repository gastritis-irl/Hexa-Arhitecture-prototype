package edu.bbte.idde.bfim2114.threelayer.persistance;


import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.HardwarePart;
import edu.bbte.idde.bfim2114.threelayer.domain.model.entity.User;
import edu.bbte.idde.bfim2114.threelayer.persistance.repository.HardwareRepository;
import edu.bbte.idde.bfim2114.threelayer.persistance.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataGenerator {

    @Bean
    CommandLineRunner initDb(HardwareRepository hardwareRepository, UserRepository userRepository) {
        return ags -> {
            User admin = userRepository.save(new User("admin", "admin"));
            User user = userRepository.save(new User("user", "user"));

            hardwareRepository.save(new HardwarePart("CPU", "Intel", "i7-9700K", 8.0, "asd", user));
            hardwareRepository.save(new HardwarePart("GPU", "Nvidia", "RTX 2080", 8.0, "asd", user));
            hardwareRepository.save(new HardwarePart("RAM", "Corsair", "Vengeance LPX", 16.0, "asd", user));
            hardwareRepository.save(new HardwarePart("Motherboard", "Asus", "ROG Strix Z390-E", 8.0, "asd", admin));
        };
    }
}
