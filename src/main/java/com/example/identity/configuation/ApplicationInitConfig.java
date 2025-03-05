package com.example.identity.configuation;

import com.example.identity.entity.User;
import com.example.identity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByTenDangNhap("admin").isEmpty()) {;

                    User user = User.builder()
                            .tenDangNhap("admin")
                            .matKhau(passwordEncoder.encode("admin"))
                            .build();
                userRepository.save(user);
            log.warn("Admin user has a been created with default password: admin,please change it");
            }
        };
    }
}
