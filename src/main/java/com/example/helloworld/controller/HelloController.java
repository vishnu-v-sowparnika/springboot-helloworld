package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.helloworld.model.ApiResponse;
import com.example.helloworld.model.AppInfo;
import java.time.LocalDateTime;

/**
 * REST Controller for Hello World endpoints
 * 
 * Demonstrates basic REST API patterns:
 * - Simple GET endpoints
 * - Query parameters
 * - Request mapping
 */
// Added a sample code for a github
//added for other trigger
//added
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * Simple hello endpoint
     * 
     * @return greeting message
     */
    @GetMapping("/hello")
    public ApiResponse hello() {
        return new ApiResponse(
            "Hello, World!",
            LocalDateTime.now(),
            "GET",
            200
        );
    }

    /**
     * Greeting with name parameter
     * 
     * @param name the name to greet
     * @return personalized greeting
     */
    @GetMapping("/greet")
    public ApiResponse greet(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        String message = "Hello, " + name + "! Welcome to Spring Boot.";
        return new ApiResponse(
            message,
            LocalDateTime.now(),
            "GET",
            200
        );
    }

    /**
     * Get application information
     * 
     * @return app info
     */
    @GetMapping("/info")
    public AppInfo getAppInfo() {
        return AppInfo.builder()
            .applicationName("Spring Boot Hello World")
            .version("1.0.0")
            .description("Simple Hello World REST API")
            .javaVersion(System.getProperty("java.version"))
            .javaVendor(System.getProperty("java.vendor"))
            .osName(System.getProperty("os.name"))
            .osVersion(System.getProperty("os.version"))
            .timestamp(LocalDateTime.now())
            .build();
    }

    /**
     * Health check endpoint
     * 
     * @return health status
     */
    @GetMapping("/health")
    public ApiResponse health() {
        return new ApiResponse(
            "Application is running healthy",
            LocalDateTime.now(),
            "GET",
            200
        );
    }

    /**
     * Echo endpoint - returns what you send
     * 
     * @param message message to echo
     * @return echoed message
     */
    @GetMapping("/echo")
    public ApiResponse echo(@RequestParam(value = "message", defaultValue = "Echo!") String message) {
        return new ApiResponse(
            "Echo: " + message,
            LocalDateTime.now(),
            "GET",
            200
        );
    }
}
