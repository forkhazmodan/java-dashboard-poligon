package com.chmax.polygon;

import com.chmax.polygon.model.User;
import com.chmax.polygon.repository.UserRepository;
import com.chmax.polygon.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootApplication
public class PolygonApplication {

    private static final Logger log = LoggerFactory.getLogger(PolygonApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PolygonApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserService userService) {
////        return (args) -> {
////            // save a few customers
//////            repository.save(new User("Max", "4myself.max@gmail.com", "password"));
////
////            // fetch all users
////            log.info("Customers found with findAll():");
////            log.info("-------------------------------");
////            for (User user : userService.getUsers()) {
//////                log.info(user);
////                System.out.println(user);
////            }
////        };
//    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
