# Spring Boot Hello World Application

A simple Spring Boot REST API application demonstrating basic server setup with Java 17 runtime.

## Project Details

- **Framework**: Spring Boot 3.2.0
- **Java Target Version**: 17
- **Java Runtime Available**: 24
- **Build Tool**: Maven
- **Server Port**: 8080

## Project Structure

```
springboot-helloworld/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/helloworld/
│   │   │       ├── HelloWorldApplication.java    # Main entry point
│   │   │       ├── controller/
│   │   │       │   └── HelloController.java      # REST endpoints
│   │   │       ├── model/
│   │   │       │   ├── ApiResponse.java          # Response wrapper
│   │   │       │   └── AppInfo.java              # App info DTO
│   │   │       └── config/
│   │   │           └── AppConfiguration.java     # App configuration
│   │   └── resources/
│   │       └── application.properties             # Configuration
│   └── test/
│       └── java/com/example/helloworld/
│           └── HelloWorldApplicationTests.java   # Unit tests
└── pom.xml                                       # Maven configuration
```

## Quick Start

### Prerequisites

- **Java 17+** (You have Java 24 ✓)
- **Maven 3.6+** (or use Maven wrapper)
- **Git** (optional)

### Verify Java Installation

```bash
java -version
javac -version
```

Expected output:
```
java version "24" ...
javac 24 ...
```

### Build the Application

Navigate to project directory:
```bash
cd d:\Data_Enng_Proj\springboot-helloworld
```

Build with Maven:
```bash
mvn clean package
```

Or if using Maven wrapper:
```bash
./mvnw clean package
```

**What happens**:
- Downloads dependencies
- Compiles code for Java 17 target
- Runs tests
- Creates executable JAR in `target/` directory

### Run the Application

#### Option 1: Using Maven
```bash
mvn spring-boot:run
```

#### Option 2: Using JAR file
```bash
java -jar target/springboot-helloworld-1.0.0.jar
```

#### Option 3: Using IDE (IntelliJ / Eclipse)
- Right-click `HelloWorldApplication.java`
- Select "Run"

**Expected Output**:
```
╔════════════════════════════════════════════╗
║   Spring Boot Hello World App Started!     ║
║                                            ║
║   Server running on: http://localhost:8080 ║
║                                            ║
║   Try these endpoints:                     ║
║   • http://localhost:8080/                 ║
║   • http://localhost:8080/api/hello        ║
║   • http://localhost:8080/api/greet?name=John ║
║   • http://localhost:8080/api/info         ║
║   • http://localhost:8080/api/health       ║
╚════════════════════════════════════════════╝
```

## API Endpoints

### 1. Simple Hello
**URL**: `GET http://localhost:8080/api/hello`

**Response**:
```json
{
  "message": "Hello, World!",
  "timestamp": "2024-04-25 10:30:45",
  "method": "GET",
  "statusCode": 200
}
```

### 2. Greet with Name
**URL**: `GET http://localhost:8080/api/greet?name=John`

**Response**:
```json
{
  "message": "Hello, John! Welcome to Spring Boot.",
  "timestamp": "2024-04-25 10:30:45",
  "method": "GET",
  "statusCode": 200
}
```

### 3. Application Info
**URL**: `GET http://localhost:8080/api/info`

**Response**:
```json
{
  "applicationName": "Spring Boot Hello World",
  "version": "1.0.0",
  "description": "Simple Hello World REST API",
  "javaVersion": "24",
  "javaVendor": "Oracle Corporation",
  "osName": "Windows 11",
  "osVersion": "10.0",
  "timestamp": "2024-04-25 10:30:45"
}
```

### 4. Health Check
**URL**: `GET http://localhost:8080/api/health`

**Response**:
```json
{
  "message": "Application is running healthy",
  "timestamp": "2024-04-25 10:30:45",
  "method": "GET",
  "statusCode": 200
}
```

### 5. Echo Service
**URL**: `GET http://localhost:8080/api/echo?message=Hello`

**Response**:
```json
{
  "message": "Echo: Hello",
  "timestamp": "2024-04-25 10:30:45",
  "method": "GET",
  "statusCode": 200
}
```

## Testing

### Run All Tests
```bash
mvn test
```

### Run Specific Test
```bash
mvn test -Dtest=HelloWorldApplicationTests
```

### Run Tests with Maven Wrapper
```bash
./mvnw test
```

**Test Coverage**:
- Context loading test
- Hello endpoint test
- Greet endpoint test
- Health endpoint test
- Info endpoint test

## Testing Endpoints with curl

### Windows PowerShell
```powershell
# Simple hello
(Invoke-WebRequest -Uri "http://localhost:8080/api/hello" -UseBasicParsing).Content

# Greet with name
(Invoke-WebRequest -Uri "http://localhost:8080/api/greet?name=World" -UseBasicParsing).Content

# App info
(Invoke-WebRequest -Uri "http://localhost:8080/api/info" -UseBasicParsing).Content | ConvertFrom-Json | ConvertTo-Json -Depth 10

# Health check
(Invoke-WebRequest -Uri "http://localhost:8080/api/health" -UseBasicParsing).Content
```

### Git Bash / Linux Terminal
```bash
# Simple hello
curl http://localhost:8080/api/hello

# Greet with name
curl http://localhost:8080/api/greet?name=World

# App info
curl http://localhost:8080/api/info | jq .

# Health check
curl http://localhost:8080/api/health
```

## Project Configuration

### Java Version Compatibility

**Target Compilation**: Java 17
```xml
<maven.compiler.source>17</maven.compiler.source>
<maven.compiler.target>17</maven.compiler.target>
```

**Why**: Spring Boot 3.2.0 requires minimum Java 17

**Your System**: Java 24
- Java 24 is **backwards compatible** - can compile and run Java 17 code
- No issues running this application

### Spring Boot Version

```xml
<version>3.2.0</version>
```

Includes:
- Spring Web MVC
- Spring Boot DevTools (auto-restart)
- Testing framework (JUnit 5, MockMvc)

### Dependencies

| Dependency | Purpose |
|-----------|---------|
| spring-boot-starter-web | REST API, embedded Tomcat |
| spring-boot-devtools | Auto-restart, live reload |
| spring-boot-starter-test | JUnit 5, MockMvc, testing |
| lombok | Annotation processing (optional) |

## Development Workflow

### 1. Make Code Changes
Edit Java files in `src/main/java/`

### 2. DevTools Auto-Restart
With DevTools enabled, Spring restarts automatically when you save files

### 3. Test Changes
Visit endpoints in browser or use curl/Postman

### 4. Recompile if Needed
```bash
mvn compile
```

## Troubleshooting

### Issue: "Maven not found"
**Solution**: Install Maven or use Maven wrapper:
```bash
# Download wrapper
mvn wrapper:wrapper

# Run with wrapper
./mvnw clean package
```

### Issue: "Cannot find symbol" during compilation
**Solution**: Ensure Java 17+ is in JAVA_HOME:
```bash
echo %JAVA_HOME%  (Windows PowerShell)
java -version
```

### Issue: Port 8080 already in use
**Solution**: Change port in `application.properties`:
```properties
server.port=8081
```

### Issue: Tests fail to run
**Solution**: Ensure test dependencies are installed:
```bash
mvn clean test
```

## Production Considerations

### Before Deploying to Production

1. **Security**
   - Update CORS settings in `AppConfiguration.java`
   - Add authentication/authorization
   - Disable actuator endpoints or secure them

2. **Configuration**
   - Use environment-specific profiles
   - Configure logging appropriately
   - Set proper error handling

3. **Monitoring**
   - Enable Spring Boot Actuator
   - Add application metrics
   - Set up log aggregation

4. **Performance**
   - Tune JVM heap settings
   - Configure connection pools
   - Add caching where appropriate

## Building for Production

### Create Executable JAR
```bash
mvn clean package
java -jar target/springboot-helloworld-1.0.0.jar
```

### Run with Custom Configuration
```bash
java -jar springboot-helloworld-1.0.0.jar --server.port=9000
```

### Using Docker (Optional)

Create `Dockerfile`:
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Build and run:
```bash
docker build -t springboot-helloworld .
docker run -p 8080:8080 springboot-helloworld
```

## File Descriptions

| File | Purpose |
|------|---------|
| `pom.xml` | Maven configuration, dependencies, build plugins |
| `HelloWorldApplication.java` | Main entry point, @SpringBootApplication |
| `HelloController.java` | REST endpoints (@RestController) |
| `ApiResponse.java` | JSON response wrapper for all endpoints |
| `AppInfo.java` | Application info model with builder pattern |
| `AppConfiguration.java` | Spring configuration (CORS, interceptors) |
| `application.properties` | Server port, logging, Spring settings |
| `HelloWorldApplicationTests.java` | Unit tests using MockMvc |

## IDE Setup

### IntelliJ IDEA
1. File → Open → Select project directory
2. Wait for Maven indexing
3. Right-click `HelloWorldApplication.java`
4. Click "Run"

### Eclipse
1. File → Import → Existing Maven Projects
2. Select project directory
3. Finish
4. Right-click → Run As → Spring Boot App

### VS Code
1. Install Extension Pack for Java
2. Install Spring Boot Extension Pack
3. Open project folder
4. Press Ctrl+F5 to run

## Next Steps

1. **Add Database**: Integrate Spring Data JPA with MySQL/PostgreSQL
2. **Add Authentication**: Implement Spring Security
3. **Add API Documentation**: Use Swagger/Springdoc
4. **Add Caching**: Implement Redis caching
5. **Add Monitoring**: Enable Spring Boot Actuator
6. **Add CI/CD**: GitHub Actions workflow

## Resources

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Spring Web MVC Guide](https://spring.io/guides/gs/serving-web-content/)
- [Spring Testing Guide](https://spring.io/guides/gs/testing-web/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Java 17 Features](https://www.oracle.com/java/technologies/javase/17-relnotes.html)

## License

MIT License - Free to use and modify

## Support

For issues or questions, refer to:
- Spring Boot documentation
- Stack Overflow (tag: spring-boot)
- GitHub Issues
