# Fault Tolerance Using Resilience4j and Rate Limiting, Retry Pattern

## Overview
This project demonstrates how to implement fault tolerance in a Spring Boot application using **Resilience4j**. It includes key patterns such as **Circuit Breaker, Rate Limiting, Bulkhead, Retry, and TimeLimiter** to handle failures gracefully and improve system resilience.

## Features
- **Circuit Breaker:** Prevents system overload by stopping calls to failing services.
- **Rate Limiting:** Controls request rates to prevent excessive load.
- **Bulkhead:** Isolates resources to limit impact of failures.
- **Retry:** Automatically retries failed operations.
- **Time Limiter:** Sets timeouts for service calls to avoid long wait times.

## Technologies Used
- Java 17
- Spring Boot 3.x
- Resilience4j
- Spring Cloud Circuit Breaker
- Spring WebFlux (for async support)
- Maven

## Getting Started
### Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven

### Installation
Clone the repository:
```sh
 git clone https://github.com/your-username/Fault_Tolerance_Using_Resilience4j.git
 cd Fault_Tolerance_Using_Resilience4j
```

### Configuration
Modify `application.yml` to set custom resilience configurations:
```yaml
resilience4j:
  circuitbreaker:
    instances:
      sampleService:
        slidingWindowSize: 10
        failureRateThreshold: 50
        waitDurationInOpenState: 5000ms
  ratelimiter:
    instances:
      sampleService:
        limitForPeriod: 5
        limitRefreshPeriod: 1s
        timeoutDuration: 0s
  retry:
    instances:
      sampleService:
        maxAttempts: 3
        waitDuration: 2s
```

### Running the Application
```sh
mvn spring-boot:run
```

### Testing Endpoints
Use **Postman** or **cURL** to test API endpoints:
```sh
curl -X GET http://localhost:8080/api/sample
```

## Example API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/api/sample` | Example service with resilience patterns |

## Monitoring with Actuator
Spring Boot Actuator is enabled for monitoring:
- Circuit Breaker Status: `http://localhost:8080/actuator/circuitbreakers`
- Rate Limiter Metrics: `http://localhost:8080/actuator/ratelimiters`

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### Contributing
Contributions are welcome! Feel free to submit a PR or open an issue.

---

### Contact
For any inquiries, reach out via **shadmanshariar007@gmail.com**.

