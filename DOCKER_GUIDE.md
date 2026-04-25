# Docker Build & Run Guide

## Building Docker Image

### Prerequisites
- Docker installed and running
- Spring Boot application built: `mvn clean package`
- JAR file exists at: `target/springboot-helloworld-1.0.0.jar`

### Build Image

```bash
# Build Docker image
docker build -t springboot-helloworld:1.0 .

# Build with tag
docker build -t springboot-helloworld:latest .

# Verify image built
docker images | grep springboot
```

### Run Container

```bash
# Run simple
docker run -p 8080:8080 springboot-helloworld:1.0

# Run with name
docker run --name my-springboot -p 8080:8080 springboot-helloworld:1.0

# Run detached (background)
docker run -d --name my-springboot -p 8080:8080 springboot-helloworld:1.0

# Run with custom port
docker run -p 9000:8080 springboot-helloworld:1.0
# Server will run on http://localhost:9000

# Run with environment variables
docker run \
  -e SERVER_PORT=8080 \
  -e JAVA_OPTS="-Xmx1024m" \
  -p 8080:8080 \
  springboot-helloworld:1.0

# Run with volume mount
docker run \
  -v $(pwd)/logs:/app/logs \
  -p 8080:8080 \
  springboot-helloworld:1.0
```

## Using Docker Compose

### Start Application

```bash
# Start services (builds if needed)
docker-compose up

# Start in background
docker-compose up -d

# View logs
docker-compose logs -f

# Stop services
docker-compose down

# Stop and remove volumes
docker-compose down -v
```

## Container Management

### View Running Containers
```bash
docker ps

# Show all containers (including stopped)
docker ps -a

# Show specific container
docker ps | grep springboot
```

### View Logs
```bash
# View container logs
docker logs my-springboot

# Follow logs (real-time)
docker logs -f my-springboot

# Last 50 lines
docker logs --tail 50 my-springboot

# With timestamps
docker logs -t my-springboot
```

### Execute Commands in Container
```bash
# Open bash shell in running container
docker exec -it my-springboot bash

# Run curl inside container
docker exec my-springboot curl http://localhost:8080/api/health

# Run Java command
docker exec my-springboot java -version
```

### Stop & Remove Containers
```bash
# Stop container
docker stop my-springboot

# Start stopped container
docker start my-springboot

# Remove container
docker rm my-springboot

# Force remove running container
docker rm -f my-springboot
```

## Testing Container

### From Host Machine
```bash
# Wait for container to start (~10 seconds)
sleep 10

# Test endpoint
curl http://localhost:8080/api/hello

# Or from another terminal while container is running
docker exec my-springboot curl http://localhost:8080/api/health
```

### Inside Container
```bash
# Open shell in container
docker exec -it my-springboot bash

# Inside container shell
curl http://localhost:8080/api/hello
curl http://localhost:8080/api/info
exit
```

## Multi-stage Build (Advanced)

For smaller images, create `Dockerfile.multistage`:

```dockerfile
# Stage 1: Build
FROM maven:3.8-openjdk-17 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /build/target/springboot-helloworld-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Build:
```bash
docker build -f Dockerfile.multistage -t springboot-helloworld:slim .
```

## Health Monitoring

### Docker Health Check

Already configured in `Dockerfile`, checks:
- Container is running
- Application responds to health endpoint
- Every 30 seconds

### Monitor Health Status
```bash
# Inspect container
docker inspect my-springboot

# Check health status specifically
docker ps --no-trunc | grep springboot
# Status will show: "Up X seconds (health: starting|healthy|unhealthy)"
```

## Troubleshooting

### Container exits immediately

```bash
# Check logs
docker logs my-springboot

# Common causes:
# - JAR file not found at target/springboot-helloworld-1.0.0.jar
# - Port already in use
# - Out of memory

# Solution: Build application first
mvn clean package
docker build -t springboot-helloworld:1.0 .
docker run -p 8080:8080 springboot-helloworld:1.0
```

### Can't access application from host

```bash
# Check if port is published
docker ps | grep springboot

# Test from inside container
docker exec my-springboot curl http://localhost:8080/api/hello

# If works inside but not outside:
# Check port mapping: -p 8080:8080
# Check firewall: Allow Docker through Windows Firewall

# Restart container with correct port
docker stop my-springboot
docker rm my-springboot
docker run -p 8080:8080 springboot-helloworld:1.0
```

### Out of Memory errors

```bash
# Increase memory limit
docker run \
  -e JAVA_OPTS="-Xmx256m -Xms128m" \
  -p 8080:8080 \
  springboot-helloworld:1.0

# Or in docker-compose.yml:
environment:
  - JAVA_OPTS=-Xmx512m -Xms256m
```

## Cleanup

```bash
# Remove container
docker rm my-springboot

# Remove image
docker rmi springboot-helloworld:1.0

# Remove unused images
docker image prune

# Remove all stopped containers
docker container prune

# Remove all unused volumes
docker volume prune

# Full cleanup (use with caution!)
docker system prune -a
```

## Docker Push to Registry (Optional)

```bash
# Tag for Docker Hub
docker tag springboot-helloworld:1.0 username/springboot-helloworld:1.0

# Push to Docker Hub
docker push username/springboot-helloworld:1.0

# Pull and run from Docker Hub
docker run -p 8080:8080 username/springboot-helloworld:1.0
```

## Complete Workflow

```bash
# 1. Build Spring Boot application
mvn clean package

# 2. Build Docker image
docker build -t springboot-helloworld:1.0 .

# 3. Run container
docker run -d --name springboot -p 8080:8080 springboot-helloworld:1.0

# 4. Wait for startup
sleep 5

# 5. Test application
curl http://localhost:8080/api/hello

# 6. View logs
docker logs springboot

# 7. Check health
docker ps | grep springboot

# 8. Stop when done
docker stop springboot
docker rm springboot
```

---

## Docker Quick Reference

| Command | Purpose |
|---------|---------|
| `docker build -t name:tag .` | Build image |
| `docker run -p 8080:8080 image:tag` | Run container |
| `docker ps` | List running containers |
| `docker logs container-name` | View logs |
| `docker exec -it container-name bash` | Open shell |
| `docker stop container-name` | Stop container |
| `docker rm container-name` | Remove container |
| `docker compose up -d` | Start services |
| `docker compose down` | Stop services |

For more help:
```bash
docker --help
docker run --help
docker compose --help
```
