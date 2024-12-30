package com.example.randomactivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class RandomActivityApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RandomActivityApplication.class, args);
        Environment env = context.getBean(Environment.class);

        System.out.println("Database URL: " + env.getProperty("spring.datasource.url"));
        System.out.println("Hibernate DDL Auto: " + env.getProperty("spring.jpa.hibernate.ddl-auto"));
    }
}
