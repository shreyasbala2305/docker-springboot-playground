# Docker & Docker Compose for Spring Boot
> A production-oriented learning repository demonstrating how modern Spring Boot applications are containerized, orchestrated, and deployed using Docker and Docker Compose.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Docker](https://img.shields.io/badge/Docker-Containerization-blue)
![Docker Compose](https://img.shields.io/badge/Docker%20Compose-Orchestration-blueviolet)
![License](https://img.shields.io/badge/License-MIT-green)

---

# Repository Goal

This repository answers one engineering question:

> **How do modern Spring Boot applications move from source code to a production-ready Docker deployment?**

Instead of focusing only on Docker commands, this repository explains the complete engineering workflow—from building a Docker image to orchestrating multiple containers with Docker Compose.

---

# Learning Objectives

By completing this repository, you will understand:

- Docker Architecture
- Images vs Containers
- Dockerfile
- Multi-Stage Builds
- Docker Volumes
- Docker Networks
- Docker Compose
- Environment Variables
- Health Checks
- Production Best Practices
- Spring Boot Containerization

---

# Repository Structure

```text
docker-springboot-playground/

README.md

docs/
├── architecture.md
├── 01-docker-fundamentals.md
├── 02-images-vs-containers.md
├── 03-dockerfile.md
├── 04-volumes.md
├── 05-networks.md
├── 06-multi-stage-builds.md
├── 07-docker-compose.md
├── 08-environment-variables.md
├── 09-health-checks.md
└── 10-production-best-practices.md

springboot-demo/

examples/

dockerfiles/

docker-compose/

notes/
```

---

# Learning Roadmap

```
Docker Fundamentals

↓

Images & Containers

↓

Dockerfile

↓

Volumes

↓

Networks

↓

Multi-Stage Builds

↓

Docker Compose

↓

Environment Variables

↓

Health Checks

↓

Production Best Practices
```

---

# Docker Architecture

```
Developer

↓

Docker CLI

↓

Docker Engine

↓

Docker Image

↓

Docker Container
```

---

# Spring Boot Containerization Flow

```
Spring Boot Project

↓

Dockerfile

↓

docker build

↓

Docker Image

↓

docker run

↓

Running Container
```

---

# Multi-Container Architecture

```
docker compose up

↓

Spring Boot

↓

PostgreSQL

↓

Docker Network

↓

Docker Volume
```

---

# Documentation

| Module | Description |
|----------|-------------|
| 01 | Docker Fundamentals |
| 02 | Images vs Containers |
| 03 | Dockerfile |
| 04 | Docker Volumes |
| 05 | Docker Networks |
| 06 | Multi-Stage Builds |
| 07 | Docker Compose |
| 08 | Environment Variables |
| 09 | Health Checks |
| 10 | Production Best Practices |

---

# Spring Boot Demo

The repository includes a production-ready Spring Boot application featuring:

- REST API
- PostgreSQL
- Validation
- Global Exception Handling
- Standard API Response
- Logging
- Spring Boot Actuator
- Docker Profile
- Multi-Stage Dockerfile

---

# Docker Examples

Practical examples are provided for:

- Basic Container
- Spring Boot Image
- PostgreSQL Volume
- Docker Networking
- Docker Compose
- Health Checks
- Multi-Stage Builds

Each example is self-contained and runnable.

---

# Build the Application

```bash
mvn clean package
```

---

# Build Docker Image

```bash
docker build -t springboot-demo:1.0 .
```

---

# Run Container

```bash
docker run -p 8080:8080 springboot-demo:1.0
```

---

# Run Complete Application

```bash
docker compose up
```

This starts:

- Spring Boot
- PostgreSQL
- Docker Network
- Docker Volume

---

# Docker Concepts Demonstrated

- Docker Images
- Docker Containers
- Dockerfile
- COPY
- WORKDIR
- CMD
- ENTRYPOINT
- Multi-Stage Builds
- Docker Compose
- Volumes
- Networks
- Environment Variables
- Health Checks

---

# Production Practices

The project follows modern backend engineering practices:

- Multi-Stage Docker Builds
- Official Base Images
- Version Pinning
- Non-Hardcoded Configuration
- Spring Profiles
- Docker Volumes
- Docker Networks
- Health Monitoring
- Persistent Storage
- Containerized PostgreSQL

---

# Technologies Used

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Maven
- Docker
- Docker Compose
- Spring Boot Actuator
- Lombok

---

# Learning Outcomes

After completing this repository, you should be able to:

- Explain Docker architecture.
- Build optimized Docker images.
- Write production-ready Dockerfiles.
- Create multi-stage builds.
- Use Docker Volumes for persistent storage.
- Configure Docker Networks.
- Orchestrate applications with Docker Compose.
- Manage runtime configuration using environment variables.
- Implement health checks.
- Containerize Spring Boot applications using production best practices.

---

# Related Repositories

This repository is part of a structured backend engineering learning path.

- Java Core
- Spring Boot Production Practices
- JWT Authentication Playground
- Docker Spring Boot Playground
- Telemedicine HMS

---

# Future Enhancements

Planned additions include:

- Redis Integration
- RabbitMQ
- NGINX Reverse Proxy
- Prometheus Monitoring
- Grafana Dashboards
- ELK Stack
- GitHub Actions CI/CD
- Kubernetes Deployment

---

# License

This repository is available under the MIT License.

---

## Author

**Shreyas Balapure**

Backend Software Engineer | Java | Spring Boot | Docker | PostgreSQL

Focused on building production-ready backend systems and continuously improving engineering practices.