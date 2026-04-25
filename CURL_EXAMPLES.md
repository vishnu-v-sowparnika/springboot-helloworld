# Testing with curl Commands

Quick reference for testing API endpoints using curl

## Setup

### PowerShell (Built-in Windows)
```powershell
# Test endpoint
$response = Invoke-WebRequest -Uri "http://localhost:8080/api/hello"
$response.Content | ConvertFrom-Json
```

### Git Bash / Linux Terminal (curl pre-installed)
```bash
# Test endpoint
curl http://localhost:8080/api/hello
```

### Windows Command Prompt (No curl, use PowerShell instead)
```cmd
# Use Invoke-WebRequest instead
powershell -Command "(Invoke-WebRequest -Uri 'http://localhost:8080/api/hello').Content"
```

## API Endpoint Tests

### 1. Hello Endpoint (No Parameters)

**Endpoint**: `GET http://localhost:8080/api/hello`

**Curl Command**:
```bash
curl http://localhost:8080/api/hello
```

**PowerShell**:
```powershell
Invoke-WebRequest -Uri "http://localhost:8080/api/hello" -UseBasicParsing | ForEach-Object { $_.Content | ConvertFrom-Json }
```

**Expected Response**:
```json
{
  "message": "Hello, World!",
  "timestamp": "2024-04-25 10:30:45",
  "method": "GET",
  "statusCode": 200
}
```

---

### 2. Greet Endpoint (With Name Parameter)

**Endpoint**: `GET http://localhost:8080/api/greet?name=YourName`

**Curl Commands**:
```bash
# With name
curl http://localhost:8080/api/greet?name=John

# With spaces (URL encoded)
curl "http://localhost:8080/api/greet?name=John%20Doe"

# Using curl --data-urlencode
curl --data-urlencode "name=John Doe" "http://localhost:8080/api/greet"

# Different names
curl http://localhost:8080/api/greet?name=Alice
curl http://localhost:8080/api/greet?name=Bob
curl http://localhost:8080/api/greet?name=Spring
```

**PowerShell**:
```powershell
# With name parameter
Invoke-WebRequest -Uri "http://localhost:8080/api/greet?name=John" -UseBasicParsing | ForEach-Object { $_.Content | ConvertFrom-Json }

# Without parameter (uses default "Guest")
Invoke-WebRequest -Uri "http://localhost:8080/api/greet" -UseBasicParsing | ForEach-Object { $_.Content | ConvertFrom-Json }
```

**Expected Response**:
```json
{
  "message": "Hello, John! Welcome to Spring Boot.",
  "timestamp": "2024-04-25 10:30:45",
  "method": "GET",
  "statusCode": 200
}
```

---

### 3. Application Info Endpoint

**Endpoint**: `GET http://localhost:8080/api/info`

**Curl Commands**:
```bash
# Get app info
curl http://localhost:8080/api/info

# Pretty print JSON (requires jq)
curl http://localhost:8080/api/info | jq .

# Pretty print with indentation
curl -s http://localhost:8080/api/info | python -m json.tool
```

**PowerShell** (Pretty Print):
```powershell
$response = Invoke-WebRequest -Uri "http://localhost:8080/api/info" -UseBasicParsing
$response.Content | ConvertFrom-Json | ConvertTo-Json -Depth 10
```

**Expected Response**:
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

---

### 4. Health Check Endpoint

**Endpoint**: `GET http://localhost:8080/api/health`

**Curl Commands**:
```bash
# Health check
curl http://localhost:8080/api/health

# With verbose output
curl -v http://localhost:8080/api/health

# Show headers
curl -i http://localhost:8080/api/health
```

**PowerShell**:
```powershell
Invoke-WebRequest -Uri "http://localhost:8080/api/health" -UseBasicParsing | ForEach-Object { $_.Content | ConvertFrom-Json }
```

**Expected Response**:
```json
{
  "message": "Application is running healthy",
  "timestamp": "2024-04-25 10:30:45",
  "method": "GET",
  "statusCode": 200
}
```

---

### 5. Echo Service Endpoint

**Endpoint**: `GET http://localhost:8080/api/echo?message=YourMessage`

**Curl Commands**:
```bash
# Echo a message
curl http://localhost:8080/api/echo?message=Hello

# Echo with spaces
curl "http://localhost:8080/api/echo?message=Hello%20World"

# Different messages
curl http://localhost:8080/api/echo?message=SpringBoot
curl http://localhost:8080/api/echo?message=Test123
curl "http://localhost:8080/api/echo?message=This%20is%20a%20test"
```

**PowerShell**:
```powershell
# Echo message
Invoke-WebRequest -Uri "http://localhost:8080/api/echo?message=Hello" -UseBasicParsing | ForEach-Object { $_.Content | ConvertFrom-Json }

# Without message (uses default "Echo!")
Invoke-WebRequest -Uri "http://localhost:8080/api/echo" -UseBasicParsing | ForEach-Object { $_.Content | ConvertFrom-Json }
```

**Expected Response**:
```json
{
  "message": "Echo: Hello",
  "timestamp": "2024-04-25 10:30:45",
  "method": "GET",
  "statusCode": 200
}
```

---

## Advanced curl Examples

### Show Response Headers
```bash
# Display headers and body
curl -i http://localhost:8080/api/hello

# Display only headers
curl -I http://localhost:8080/api/hello
```

### Measure Response Time
```bash
# With timing information
curl -w "@curl-format.txt" -o /dev/null -s http://localhost:8080/api/hello
```

### Save Response to File
```bash
# Save JSON to file
curl http://localhost:8080/api/info > response.json

# On PowerShell
(Invoke-WebRequest -Uri "http://localhost:8080/api/info").Content | Out-File response.json
```

### Multiple Requests
```bash
# Test all endpoints
curl http://localhost:8080/api/hello
curl http://localhost:8080/api/greet?name=Alice
curl http://localhost:8080/api/info
curl http://localhost:8080/api/health
curl http://localhost:8080/api/echo?message=Test
```

### With Custom Headers
```bash
# Add custom header
curl -H "X-Custom-Header: MyValue" http://localhost:8080/api/hello

# Add multiple headers
curl -H "Content-Type: application/json" \
     -H "Accept: application/json" \
     http://localhost:8080/api/info
```

### Verbose Output (Debugging)
```bash
# Show detailed information
curl -v http://localhost:8080/api/hello

# Very verbose (includes data)
curl -vv http://localhost:8080/api/health
```

---

## Browser Testing

Simply copy-paste these URLs into your browser:

```
http://localhost:8080/api/hello

http://localhost:8080/api/greet?name=John

http://localhost:8080/api/info

http://localhost:8080/api/health

http://localhost:8080/api/echo?message=Hello
```

---

## Testing Script (Batch File)

Create `test-all.bat`:
```batch
@echo off
echo Testing Spring Boot Application...
echo.

echo 1. Testing /api/hello
curl http://localhost:8080/api/hello
echo.
echo.

echo 2. Testing /api/greet
curl "http://localhost:8080/api/greet?name=John"
echo.
echo.

echo 3. Testing /api/health
curl http://localhost:8080/api/health
echo.
echo.

echo 4. Testing /api/info
curl http://localhost:8080/api/info
echo.
echo.

echo 5. Testing /api/echo
curl "http://localhost:8080/api/echo?message=Hello"
echo.
echo.

echo All tests completed!
pause
```

Run with:
```bash
.\test-all.bat
```

---

## Testing Script (Bash)

Create `test-all.sh`:
```bash
#!/bin/bash

echo "Testing Spring Boot Application..."
echo ""

echo "1. Testing /api/hello"
curl http://localhost:8080/api/hello
echo ""
echo ""

echo "2. Testing /api/greet"
curl "http://localhost:8080/api/greet?name=John"
echo ""
echo ""

echo "3. Testing /api/health"
curl http://localhost:8080/api/health
echo ""
echo ""

echo "4. Testing /api/info"
curl http://localhost:8080/api/info | jq .
echo ""
echo ""

echo "5. Testing /api/echo"
curl "http://localhost:8080/api/echo?message=Hello"
echo ""
echo ""

echo "All tests completed!"
```

Run with:
```bash
bash test-all.sh
```

---

## Troubleshooting

### curl not found (Windows)
- Use PowerShell instead: `Invoke-WebRequest`
- Or install: `choco install curl` (via Chocolatey)

### Connection refused
- Verify server is running: `mvn spring-boot:run`
- Check if port 8080 is available
- Change port in `application.properties` if needed

### Timeout errors
- Server might be slow on first request
- Wait a few seconds and retry
- Check console logs for errors

### JSON formatting issues
- Install `jq`: `choco install jq` (Windows)
- Or use: `python -m json.tool`
- Or use browser for nice formatting

---

## Quick Reference Table

| Endpoint | Method | Parameters | Description |
|----------|--------|-----------|-------------|
| `/api/hello` | GET | None | Simple hello message |
| `/api/greet` | GET | `name` (optional) | Personalized greeting |
| `/api/info` | GET | None | Application information |
| `/api/health` | GET | None | Health check |
| `/api/echo` | GET | `message` (optional) | Echo service |

---

**Tips**:
- Use browser for quick testing
- Use curl/PowerShell for automation
- Use `jq` for pretty-printing JSON
- Save responses to file for comparison
