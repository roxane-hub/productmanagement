package com.example.ecommerceprojectmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class ECommerceprojectmanagementApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceprojectmanagementApplicationTests.class, args);
    }
    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        return new ServletRegistrationBean<>(dispatcherServlet, "/api/*");
    }



    @Bean
    public CommandLineRunner seedData() {
        return args -> {

            System.out.println("Application started — seedData would run here if repositories injected.");
        };
    }
}
