# Use official OpenJDK 17 runtime as base image
# (Java 24 code compiled for Java 17 is compatible)
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy the built JAR file from target directory
COPY target/springboot-helloworld-1.0.0.jar app.jar

# Expose port 8080 (where Spring Boot runs)
EXPOSE 8080

# Health check (optional)
HEALTHCHECK --interval=30s --timeout=10s --start-period=40s --retries=3 \
  CMD java -cp app.jar org.springframework.boot.loader.JarLauncher && \
  curl -f http://localhost:8080/api/health || exit 1

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Alternative: with JVM optimization
# ENTRYPOINT ["java", "-Xmx512m", "-Xms256m", "-XX:+UseG1GC", "-jar", "app.jar"]
