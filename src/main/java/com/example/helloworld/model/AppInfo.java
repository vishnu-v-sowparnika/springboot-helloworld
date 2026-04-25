package com.example.helloworld.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Application Information DTO
 */
public class AppInfo {
    private String applicationName;
    private String version;
    private String description;
    private String javaVersion;
    private String javaVendor;
    private String osName;
    private String osVersion;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    // Constructor
    public AppInfo(String applicationName, String version, String description,
                   String javaVersion, String javaVendor, String osName, String osVersion,
                   LocalDateTime timestamp) {
        this.applicationName = applicationName;
        this.version = version;
        this.description = description;
        this.javaVersion = javaVersion;
        this.javaVendor = javaVendor;
        this.osName = osName;
        this.osVersion = osVersion;
        this.timestamp = timestamp;
    }

    // Builder pattern
    public static AppInfoBuilder builder() {
        return new AppInfoBuilder();
    }

    public static class AppInfoBuilder {
        private String applicationName;
        private String version;
        private String description;
        private String javaVersion;
        private String javaVendor;
        private String osName;
        private String osVersion;
        private LocalDateTime timestamp;

        public AppInfoBuilder applicationName(String applicationName) {
            this.applicationName = applicationName;
            return this;
        }

        public AppInfoBuilder version(String version) {
            this.version = version;
            return this;
        }

        public AppInfoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public AppInfoBuilder javaVersion(String javaVersion) {
            this.javaVersion = javaVersion;
            return this;
        }

        public AppInfoBuilder javaVendor(String javaVendor) {
            this.javaVendor = javaVendor;
            return this;
        }

        public AppInfoBuilder osName(String osName) {
            this.osName = osName;
            return this;
        }

        public AppInfoBuilder osVersion(String osVersion) {
            this.osVersion = osVersion;
            return this;
        }

        public AppInfoBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public AppInfo build() {
            return new AppInfo(applicationName, version, description, javaVersion, 
                             javaVendor, osName, osVersion, timestamp);
        }
    }

    // Getters and Setters
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getJavaVendor() {
        return javaVendor;
    }

    public void setJavaVendor(String javaVendor) {
        this.javaVendor = javaVendor;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "applicationName='" + applicationName + '\'' +
                ", version='" + version + '\'' +
                ", description='" + description + '\'' +
                ", javaVersion='" + javaVersion + '\'' +
                ", javaVendor='" + javaVendor + '\'' +
                ", osName='" + osName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
