package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Hello World Application
 * 
 * Main entry point for the application.
 * This application demonstrates basic Spring Boot setup and REST endpoints.
 * 
 * @author Example
 * @version 1.0.0
 */
@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   Spring Boot Hello World App Started!     ║");
        System.out.println("║                                            ║");
        System.out.println("║   Server running on: http://localhost:8080 ║");
        System.out.println("║                                            ║");
        System.out.println("║   Try these endpoints:                     ║");
        System.out.println("║   • http://localhost:8080/                 ║");
        System.out.println("║   • http://localhost:8080/api/hello        ║");
        System.out.println("║   • http://localhost:8080/api/greet?name=John ║");
        System.out.println("║   • http://localhost:8080/api/info         ║");
        System.out.println("║   • http://localhost:8080/api/health       ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
