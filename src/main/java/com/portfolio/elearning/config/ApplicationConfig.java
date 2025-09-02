package com.portfolio.elearning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.portfolio.elearning.repository")
@EnableJpaAuditing
@EnableTransactionManagement
public class ApplicationConfig {
    // Additional beans will be defined here
}
