#!/bin/bash

# Spring Boot Hello World - Quick Run Script for Linux/Mac/Git Bash

echo ""
echo "========================================"
echo " Spring Boot Hello World Application"
echo "========================================"
echo ""

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "ERROR: Java is not installed or not in PATH"
    echo ""
    echo "Please ensure Java is installed and JAVA_HOME is set correctly"
    exit 1
fi

# Display Java version
echo "Checking Java version..."
java -version
echo ""

# Check if Maven is installed (optional)
if ! command -v mvn &> /dev/null; then
    echo "WARNING: Maven not found. Will try to use Maven wrapper."
fi

echo ""
echo "Building Spring Boot application..."
echo "This may take a minute on first run..."
echo ""

# Build the application
if [ -f "mvnw" ]; then
    echo "Using Maven Wrapper..."
    chmod +x mvnw
    ./mvnw clean package
else
    echo "Using Maven..."
    mvn clean package
fi

if [ $? -ne 0 ]; then
    echo ""
    echo "ERROR: Build failed!"
    exit 1
fi

echo ""
echo "========================================"
echo " Build Successful!"
echo "========================================"
echo ""

# Check if JAR was created
if [ -f "target/springboot-helloworld-1.0.0.jar" ]; then
    echo ""
    echo "Starting Spring Boot application..."
    echo ""
    echo "Application will start on: http://localhost:8080"
    echo ""
    echo "Available endpoints:"
    echo "  - GET http://localhost:8080/api/hello"
    echo "  - GET http://localhost:8080/api/greet?name=YourName"
    echo "  - GET http://localhost:8080/api/info"
    echo "  - GET http://localhost:8080/api/health"
    echo "  - GET http://localhost:8080/api/echo?message=Hello"
    echo ""
    echo "Press Ctrl+C to stop the server"
    echo ""
    echo "========================================"
    echo ""
    
    java -jar target/springboot-helloworld-1.0.0.jar
else
    echo "ERROR: JAR file not found at target/springboot-helloworld-1.0.0.jar"
    exit 1
fi
