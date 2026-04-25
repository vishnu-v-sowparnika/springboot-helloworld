# System Requirements & Compatibility

## Minimum Requirements

| Component | Requirement | Your System | Status |
|-----------|-------------|------------|--------|
| **Java** | 17+ | 24 | ✅ Compatible |
| **Maven** | 3.6+ | (auto-detect) | ✅ OK |
| **RAM** | 512 MB | (system dependent) | ✅ OK |
| **Disk** | 500 MB | (project: ~200 MB) | ✅ OK |
| **OS** | Any | Windows 11 | ✅ OK |

## Detailed Compatibility

### Java Version

**Target Runtime**: Java 17
**Your Runtime**: Java 24

**Why this works**:
- Java is **forward/backward compatible** within major versions
- Java 24 can compile and run code targeted for Java 17
- No compatibility issues

**Check your Java**:
```bash
# In PowerShell
java -version
javac -version

# Expected for your system:
# java version "24"
# javac 24
```

### Spring Boot Compatibility

| Component | Version | Compatibility |
|-----------|---------|---------------|
| Spring Boot | 3.2.0 | Requires Java 17+ ✅ |
| Spring Framework | 6.1.0 | Works with Java 24 ✅ |
| Tomcat (embedded) | 10.1.x | Works with Java 24 ✅ |
| JUnit 5 | 5.9.x | Works with Java 24 ✅ |

### Maven Compatibility

| Component | Requirement | Status |
|-----------|-------------|--------|
| Maven | 3.6+ | Usually pre-installed ✅ |
| Maven Plugin (Compiler) | 3.11.0 | Targets Java 17 ✅ |
| Maven Plugin (Surefire) | 3.1.2 | Runs tests ✅ |

**If Maven not found**:
- Option 1: Install from https://maven.apache.org/
- Option 2: Use built-in Maven Wrapper (`mvnw`)

### OS Compatibility

| OS | Status | Notes |
|----|--------|-------|
| Windows 10/11 | ✅ Full Support | Use `run.bat` script |
| macOS | ✅ Full Support | Use `run.sh` script |
| Linux | ✅ Full Support | Use `run.sh` script |
| Docker | ✅ Full Support | Use `Dockerfile` |

## Pre-flight Checklist

```bash
# 1. Check Java installation
java -version
# Output should show Java 17 or higher

# 2. Check Maven installation
mvn -version
# Output should show Maven 3.6+

# 3. Check disk space
# At least 1 GB free for dependencies

# 4. Check network connection
# First build will download ~200 MB of dependencies
```

## Potential Issues & Solutions

### Issue 1: Java Not Found

**Error Message**:
```
'java' is not recognized as an internal or external command
```

**Solutions**:

**Option A: Add Java to PATH (Windows)**
```powershell
# Find your Java installation
Get-Command java
# Note the path, e.g., C:\Program Files\Java\jdk-24\bin

# Add to PATH via Environment Variables:
# 1. Press Win + Pause
# 2. Advanced system settings → Environment Variables
# 3. Add JAVA_HOME: C:\Program Files\Java\jdk-24
# 4. Add to PATH: %JAVA_HOME%\bin
# 5. Restart Terminal
```

**Option B: Set JAVA_HOME temporarily**
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-24"
java -version
```

**Option C: Full Java path**
```powershell
"C:\Program Files\Java\jdk-24\bin\java" -version
```

### Issue 2: Maven Not Found

**Error Message**:
```
'mvn' is not recognized as an internal or external command
```

**Solutions**:

**Option A: Install Maven**
- Download from: https://maven.apache.org/download.cgi
- Extract to: `C:\Program Files\apache-maven`
- Add to PATH: `C:\Program Files\apache-maven\bin`

**Option B: Use Maven Wrapper (built-in)**
```bash
# Instead of:
mvn clean package

# Use:
./mvnw clean package      (Git Bash / Mac)
mvnw.cmd clean package    (Windows Command Prompt)
```

**Option C: Use IDE (IntelliJ, Eclipse, VS Code)**
- IDEs come with built-in Maven support
- No manual setup needed

### Issue 3: Port 8080 Already in Use

**Error Message**:
```
Tomcat initialization failed: port 8080 required but unavailable
```

**Solutions**:

**Option A: Use different port**
```bash
# Edit src/main/resources/application.properties
# Change:
# server.port=8080
# To:
# server.port=8081

# Or pass via command line:
java -jar target/springboot-helloworld-1.0.0.jar --server.port=8081
```

**Option B: Find what's using port 8080**
```powershell
# Windows
netstat -ano | findstr :8080
# Then kill the process:
taskkill /PID <PID> /F
```

```bash
# Mac/Linux
lsof -i :8080
kill -9 <PID>
```

### Issue 4: Insufficient Memory

**Error Message**:
```
java.lang.OutOfMemoryError: Java heap space
```

**Solutions**:

**Increase heap size**:
```bash
# Add JVM arguments:
java -Xmx1024m -jar target/springboot-helloworld-1.0.0.jar
# -Xmx1024m = 1 GB max heap
```

### Issue 5: Build Takes Forever

**Normal**: First build takes 1-2 minutes (downloading ~200 MB dependencies)

**Solutions**:
- Subsequent builds are much faster (cached dependencies)
- Check internet connection
- Increase Maven heap:
  ```bash
  export MAVEN_OPTS=-Xmx1024m
  mvn clean package
  ```

### Issue 6: Test Failures

**Error**: Tests fail during build

**Solutions**:
```bash
# Skip tests during build
mvn clean package -DskipTests

# Run tests separately
mvn test

# Run specific test
mvn test -Dtest=HelloWorldApplicationTests

# Run with more logging
mvn test -X
```

### Issue 7: Dependencies Downloaded Incorrectly

**Error**: Dependencies not found or corrupted

**Solutions**:
```bash
# Clear Maven cache
rm -rf ~/.m2/repository    (Mac/Linux)
rmdir /s %USERPROFILE%\.m2\repository  (Windows)

# Rebuild
mvn clean package
```

## Performance Tips

### Build Optimization

```bash
# Parallel Maven build
mvn -T 1C clean package
# -T 1C = 1 thread per core

# Skip tests for faster builds (development only)
mvn clean package -DskipTests

# Use Maven daemon for faster subsequent builds
mvnd clean package
```

### Runtime Optimization

```bash
# Custom JVM settings
java -Xmx512m -Xms256m -XX:+UseG1GC \
  -jar target/springboot-helloworld-1.0.0.jar
```

### Development Tips

1. **Use DevTools for faster reload**
   - Changes in code reload automatically
   - Configured in `pom.xml`

2. **Use IDE debugging**
   - Set breakpoints
   - Step through code
   - Inspect variables

3. **Use hot reload**
   - Spring Boot DevTools watches `src/` directory
   - Restarts app automatically on save

## Network & Firewall

If application doesn't respond:

1. **Check firewall allows port 8080**
   ```powershell
   # Windows Firewall might block new apps
   # Allow Java through Windows Firewall
   ```

2. **Verify server started**
   - Check console for startup message
   - Look for "Started HelloWorldApplication in X seconds"

3. **Test connectivity**
   ```powershell
   # From another terminal:
   curl http://localhost:8080/api/health
   ```

## Docker Requirements (Optional)

If running in Docker:
- Docker: 20.10+ or Docker Desktop 4.0+
- Image uses: `openjdk:17-jdk-slim` (compatible)

```bash
docker build -t springboot-helloworld .
docker run -p 8080:8080 springboot-helloworld
```

## Summary Checklist

- ✅ Java 17+ installed (You have 24)
- ✅ Maven 3.6+ installed or using Maven Wrapper
- ✅ At least 500 MB free disk space
- ✅ Port 8080 available (or configure different port)
- ✅ Internet connection for first-time build
- ✅ IDE installed (optional, can use command line)

**You're all set!** Start with `QUICKSTART.md`.
