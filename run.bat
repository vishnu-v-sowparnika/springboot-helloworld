@echo off
REM Spring Boot Hello World - Quick Run Script for Windows

color 0a
title Spring Boot Hello World Application

echo.
echo ========================================
echo  Spring Boot Hello World Application
echo ========================================
echo.

REM Check if Java is installed
where java >nul 2>nul
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo.
    echo Please ensure Java is installed and JAVA_HOME is set correctly
    pause
    exit /b 1
)

REM Display Java version
echo Checking Java version...
java -version
echo.

REM Check if Maven is installed (optional)
where mvn >nul 2>nul
if %errorlevel% neq 0 (
    echo WARNING: Maven not found. Will try to use Maven wrapper.
)

echo.
echo Building Spring Boot application...
echo This may take a minute on first run...
echo.

REM Build the application
if exist mvnw.cmd (
    echo Using Maven Wrapper...
    call mvnw clean package
) else (
    echo Using Maven...
    call mvn clean package
)

if %errorlevel% neq 0 (
    echo.
    echo ERROR: Build failed!
    pause
    exit /b 1
)

echo.
echo ========================================
echo  Build Successful!
echo ========================================
echo.

REM Check if JAR was created
if exist "target\springboot-helloworld-1.0.0.jar" (
    echo.
    echo Starting Spring Boot application...
    echo.
    echo Application will start on: http://localhost:8080
    echo.
    echo Available endpoints:
    echo   - GET http://localhost:8080/api/hello
    echo   - GET http://localhost:8080/api/greet?name=YourName
    echo   - GET http://localhost:8080/api/info
    echo   - GET http://localhost:8080/api/health
    echo   - GET http://localhost:8080/api/echo?message=Hello
    echo.
    echo Press Ctrl+C to stop the server
    echo.
    echo ========================================
    echo.
    
    java -jar target\springboot-helloworld-1.0.0.jar
) else (
    echo ERROR: JAR file not found at target\springboot-helloworld-1.0.0.jar
    pause
    exit /b 1
)

pause
