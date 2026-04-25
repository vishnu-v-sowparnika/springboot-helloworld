# Spring Boot Hello World - Quick Start Guide

## 30 Second Quick Start

### Windows (PowerShell / Command Prompt)

```bash
# 1. Navigate to project
cd d:\Data_Enng_Proj\springboot-helloworld

# 2. Run the application
# Option A: Using the provided script
.\run.bat

# Option B: Using Maven directly
mvn spring-boot:run

# Option C: Build then run JAR
mvn clean package
java -jar target/springboot-helloworld-1.0.0.jar
```

### Linux / Mac / Git Bash

```bash
# 1. Navigate to project
cd ~/Data_Enng_Proj/springboot-helloworld

# 2. Run the application
# Option A: Using the provided script
bash run.sh

# Option B: Using Maven directly
mvn spring-boot:run

# Option C: Build then run JAR
mvn clean package
java -jar target/springboot-helloworld-1.0.0.jar
```

## What Will Happen

1. **Build Phase** (first run ~1-2 min)
   - Downloads Spring Boot dependencies
   - Compiles Java code (targets Java 17)
   - Runs unit tests
   - Creates executable JAR file

2. **Run Phase** (~5 seconds)
   - Starts embedded Tomcat server
   - Application listens on port 8080
   - Displays beautiful ASCII startup banner

3. **Console Output**
   ```
   ╔════════════════════════════════════════════╗
   ║   Spring Boot Hello World App Started!     ║
   ║                                            ║
   ║   Server running on: http://localhost:8080 ║
   ║                                            ║
   ║   Try these endpoints:                     ║
   ║   • http://localhost:8080/api/hello        ║
   ║   • http://localhost:8080/api/greet?name=John ║
   ║   • http://localhost:8080/api/info         ║
   ║   • http://localhost:8080/api/health       ║
   ╚════════════════════════════════════════════╝
   ```

## Testing the Server

### Using Browser
Open these URLs in your browser:
- http://localhost:8080/api/hello
- http://localhost:8080/api/greet?name=YourName
- http://localhost:8080/api/info
- http://localhost:8080/api/health

### Using PowerShell

```powershell
# Simple hello
Invoke-WebRequest -Uri "http://localhost:8080/api/hello" | Select-Object -ExpandProperty Content | ConvertFrom-Json

# Greet endpoint
Invoke-WebRequest -Uri "http://localhost:8080/api/greet?name=John" | Select-Object -ExpandProperty Content | ConvertFrom-Json

# App info
Invoke-WebRequest -Uri "http://localhost:8080/api/info" | Select-Object -ExpandProperty Content | ConvertFrom-Json
```

### Using Curl (Git Bash / PowerShell)

```bash
# Simple hello
curl http://localhost:8080/api/hello

# Greet endpoint
curl "http://localhost:8080/api/greet?name=John"

# App info (pretty print with jq)
curl http://localhost:8080/api/info | jq .
```

## Common Commands

| Command | Description |
|---------|-------------|
| `mvn clean package` | Build application (creates JAR) |
| `mvn spring-boot:run` | Run directly without building JAR |
| `mvn test` | Run unit tests |
| `mvn clean` | Delete build output |
| `java -jar target/springboot-helloworld-1.0.0.jar` | Run built JAR |

## Folder Structure

```
springboot-helloworld/
├── src/
│   ├── main/
│   │   ├── java/com/example/helloworld/
│   │   │   ├── HelloWorldApplication.java    ← Main entry point
│   │   │   ├── controller/HelloController.java
│   │   │   ├── model/ApiResponse.java
│   │   │   ├── model/AppInfo.java
│   │   │   └── config/AppConfiguration.java
│   │   └── resources/application.properties
│   └── test/java/.../HelloWorldApplicationTests.java
├── target/                                   ← Build output
│   └── springboot-helloworld-1.0.0.jar
├── pom.xml                                  ← Maven config
├── run.bat                                  ← Windows runner
├── run.sh                                   ← Linux/Mac runner
└── README.md                                ← Full documentation
```

## If Something Goes Wrong

### Problem: "Maven not found"
```bash
# Check if Maven is installed
mvn -version

# If not, download from: https://maven.apache.org/
# Or use built-in Maven wrapper:
./mvnw clean package  (Linux/Mac)
mvnw.cmd clean package (Windows)
```

### Problem: Port 8080 already in use
```bash
# Edit application.properties
server.port=8081

# Then restart the app
```

### Problem: Build fails with Java version error
```bash
# Check your Java version
java -version

# Should show 17 or higher (you have 24, so fine!)
# Make sure JAVA_HOME is set correctly
echo %JAVA_HOME%
```

### Problem: Tests fail
```bash
# Run tests individually
mvn test -Dtest=HelloWorldApplicationTests
```

## Next: Test the Endpoints

Once the server is running, test these endpoints:

### 1. Hello Endpoint
```
GET http://localhost:8080/api/hello
```
Returns: `{"message":"Hello, World!"}`

### 2. Greet with Parameter
```
GET http://localhost:8080/api/greet?name=Alice
```
Returns: `{"message":"Hello, Alice! Welcome to Spring Boot."}`

### 3. Application Info
```
GET http://localhost:8080/api/info
```
Returns: Java version, OS info, etc.

### 4. Health Check
```
GET http://localhost:8080/api/health
```
Returns: `{"message":"Application is running healthy"}`

### 5. Echo Service
```
GET http://localhost:8080/api/echo?message=Test
```
Returns: `{"message":"Echo: Test"}`

## Stopping the Server

Press `Ctrl+C` in the terminal to stop the server.

## All Set! 🚀

Your Spring Boot Hello World application is ready to use.
For more details, see `README.md`.
