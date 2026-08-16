# Spring Boot Image

## Build

```bash
mvn clean package
```

```bash
docker build -t springboot-demo .
```

## Run

```bash
docker run -p 8080:8080 springboot-demo
```

Visit

```
http://localhost:8080/actuator/health
```