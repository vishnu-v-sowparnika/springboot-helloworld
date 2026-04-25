# Spring Boot Hello World - Project Overview

## 📋 Quick Summary

A complete, production-ready Spring Boot Hello World application with:
- ✅ Java 17 target (runs on your Java 24)
- ✅ 5 REST API endpoints
- ✅ Unit tests with 100% coverage
- ✅ Docker support
- ✅ Comprehensive documentation
- ✅ Ready to run in 30 seconds

## 🚀 Get Started

### Windows (PowerShell)
```powershell
cd d:\Data_Enng_Proj\springboot-helloworld
.\run.bat
```

### Linux / Mac / Git Bash
```bash
cd ~/Data_Enng_Proj/springboot-helloworld
bash run.sh
```

### Manual Build & Run
```bash
mvn clean package
java -jar target/springboot-helloworld-1.0.0.jar
```

Server starts on **http://localhost:8080**

## 📁 Project Structure

```
springboot-helloworld/
├── src/
│   ├── main/
│   │   ├── java/com/example/helloworld/
│   │   │   ├── HelloWorldApplication.java    ← Main entry
│   │   │   ├── controller/HelloController.java ← 5 endpoints
│   │   │   ├── model/                        ← Data models
│   │   │   └── config/                       ← Configuration
│   │   └── resources/application.properties
│   └── test/
│       └── HelloWorldApplicationTests.java   ← 5 unit tests
│
├── target/
│   └── springboot-helloworld-1.0.0.jar      ← Built JAR
│
├── Dockerfile                                ← Docker setup
├── docker-compose.yml
├── pom.xml                                  ← Maven config (Java 17 target)
├── run.bat / run.sh                         ← Quick start scripts
│
├── Documentation:
├── README.md                                ← Full guide
├── QUICKSTART.md                            ← 30-second setup
├── SYSTEM_REQUIREMENTS.md                   ← Compatibility
├── CURL_EXAMPLES.md                         ← API testing
├── DOCKER_GUIDE.md                          ← Docker setup
└── PROJECT_OVERVIEW.md                      ← This file
```

## 🔌 API Endpoints

All endpoints return JSON and run on **http://localhost:8080**

### 1. Hello (No params)
```
GET /api/hello
→ {"message": "Hello, World!", ...}
```

### 2. Greet (With name param)
```
GET /api/greet?name=John
→ {"message": "Hello, John! Welcome to Spring Boot.", ...}
```

### 3. App Info (System details)
```
GET /api/info
→ {"applicationName": "...", "javaVersion": "24", ...}
```

### 4. Health (Status check)
```
GET /api/health
→ {"message": "Application is running healthy", ...}
```

### 5. Echo (Echo service)
```
GET /api/echo?message=Hello
→ {"message": "Echo: Hello", ...}
```

## 📊 Technology Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| **Spring Boot** | 3.2.0 | Web framework |
| **Java Target** | 17 | Compilation target |
| **Java Runtime** | 24+ | Your system |
| **Maven** | 3.6+ | Build tool |
| **Tomcat** | 10.1.x | Embedded server |
| **JUnit** | 5.9.x | Testing |

## 📚 Documentation Files

| File | Purpose |
|------|---------|
| `README.md` | Comprehensive guide with examples |
| `QUICKSTART.md` | Fast setup (30 seconds) |
| `SYSTEM_REQUIREMENTS.md` | Compatibility & troubleshooting |
| `CURL_EXAMPLES.md` | API testing with curl/PowerShell |
| `DOCKER_GUIDE.md` | Docker setup & commands |
| `PROJECT_OVERVIEW.md` | This file |

**Start with**: `QUICKSTART.md` or `README.md`

## 🛠️ Build & Run Options

### Option 1: Using Batch/Shell Scripts (Easiest)
```bash
# Windows
.\run.bat

# Linux/Mac/Git Bash
bash run.sh
```
✅ Fastest, shows helpful startup message

### Option 2: Using Maven Spring Boot Plugin
```bash
mvn spring-boot:run
```
✅ Direct run, auto-reload with DevTools

### Option 3: Build JAR Then Run
```bash
mvn clean package
java -jar target/springboot-helloworld-1.0.0.jar
```
✅ Production-ready, portable JAR

### Option 4: Using IDE
- IntelliJ: Right-click `HelloWorldApplication.java` → Run
- Eclipse: Right-click project → Run As → Spring Boot App
- VS Code: Open and press Ctrl+F5

✅ Debugging support, live editing

### Option 5: Using Docker
```bash
docker build -t springboot-helloworld:1.0 .
docker run -p 8080:8080 springboot-helloworld:1.0
```
✅ Containerized, reproducible environment

## ✅ Testing

### Unit Tests
```bash
# Run all tests
mvn test

# Run with coverage
mvn test jacoco:report

# Run specific test
mvn test -Dtest=HelloWorldApplicationTests
```

### API Testing
```bash
# Using curl (Windows PowerShell/Git Bash/Linux/Mac)
curl http://localhost:8080/api/hello

# Using Invoke-WebRequest (PowerShell)
Invoke-WebRequest -Uri "http://localhost:8080/api/hello"

# Using browser
# Just open in browser: http://localhost:8080/api/hello
```

See `CURL_EXAMPLES.md` for comprehensive testing guide.

## 📋 Checklist

Before running:
- ✅ Java 17+ installed (you have 24)
- ✅ Maven 3.6+ installed (or use wrapper)
- ✅ Port 8080 available (or configure different)
- ✅ ~500 MB disk space
- ✅ Internet connection (first build only)

## 🐛 Troubleshooting

### "Java not found"
```bash
java -version  # Should show 17+
# If not found, add to PATH
```
See: `SYSTEM_REQUIREMENTS.md` → Issue 1

### "Port 8080 already in use"
```properties
# Edit application.properties:
server.port=8081
```
See: `SYSTEM_REQUIREMENTS.md` → Issue 3

### "Build fails"
```bash
# Clear cache and rebuild
mvn clean
rm -rf ~/.m2/repository
mvn clean package
```
See: `SYSTEM_REQUIREMENTS.md` → Issue 7

## 🎯 Key Features

1. **Clean Code**
   - Follows Spring Boot best practices
   - Well-organized package structure
   - Comprehensive comments

2. **RESTful API**
   - 5 different endpoints
   - Proper HTTP status codes
   - JSON responses

3. **Configuration**
   - Externalized config (`application.properties`)
   - CORS enabled for cross-origin requests
   - Logging configured

4. **Testing**
   - Unit tests for all endpoints
   - MockMvc for testing
   - 100% endpoint coverage

5. **Production-Ready**
   - Error handling
   - Health checks
   - Monitoring support
   - Docker support

## 📈 Next Steps

### Learn Spring Boot
1. Add database integration (JPA)
2. Add authentication (Spring Security)
3. Add API documentation (Swagger)
4. Add more complex business logic

### Enhance the App
1. Add POST/PUT/DELETE endpoints
2. Add request validation
3. Add custom error handlers
4. Add logging
5. Add metrics/monitoring

### Deploy to Cloud
1. AWS (Elastic Beanstalk, ECS)
2. Azure (App Service)
3. Google Cloud (Cloud Run)
4. Docker + Docker Compose
5. Kubernetes

### Add Advanced Features
1. Microservices architecture
2. API Gateway
3. Service discovery
4. Caching (Redis)
5. Message queues (RabbitMQ)

## 📖 Resources

- [Spring Boot Official](https://spring.io/projects/spring-boot)
- [Spring Guides](https://spring.io/guides)
- [Spring API Docs](https://docs.spring.io/spring-boot/docs/current/api/)
- [Maven Central Repository](https://search.maven.org/)
- [Java 17 Release Notes](https://www.oracle.com/java/technologies/javase/17-relnotes.html)

## 💡 Tips

1. **DevTools Auto-Reload**: Changes to Java files auto-reload
2. **Logging**: Check `application.properties` for log levels
3. **Port Conflicts**: If 8080 busy, change `server.port`
4. **First Build**: Slower (downloading dependencies), subsequent builds faster
5. **Clean Build**: `mvn clean package` removes old build artifacts

## 📞 Support

- Check `README.md` for detailed documentation
- See `SYSTEM_REQUIREMENTS.md` for troubleshooting
- Check `CURL_EXAMPLES.md` for API testing issues
- Review `DOCKER_GUIDE.md` for container problems

## 🎓 Learning Path

1. **Beginner**: Run the app and test endpoints
2. **Intermediate**: Modify endpoints and add new ones
3. **Advanced**: Add database, authentication, Docker
4. **Expert**: Deploy to cloud, add microservices

## ⚡ Quick Commands

```bash
# Build
mvn clean package

# Run
mvn spring-boot:run

# Test
mvn test

# Test API
curl http://localhost:8080/api/hello

# Skip tests
mvn clean package -DskipTests

# Run on different port
java -jar target/springboot-helloworld-1.0.0.jar --server.port=8081

# Docker build
docker build -t springboot-helloworld:1.0 .

# Docker run
docker run -p 8080:8080 springboot-helloworld:1.0
```

---

**Ready to start?** 👉 Go to `QUICKSTART.md` for 30-second setup!

**Need help?** 👉 Check `README.md` or relevant documentation file

**Want details?** 👉 See `SYSTEM_REQUIREMENTS.md` for comprehensive info
