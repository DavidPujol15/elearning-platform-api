package com.portfolio.elearning;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "E-Learning Platform API",
                version = "1.0.0",
                description = "REST API for E-Learning Platform - Portfolio Project",
                contact = @Contact(
                        name = "David Pujol",
                        email = "davidpujol.work@gmail.com",
                        url = "https://github.com/yourusername"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        )
)
public class ElearningPlatformApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElearningPlatformApiApplication.class, args);
    }

}
