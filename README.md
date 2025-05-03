# Patient Management System (PMS)

A scalable, backend-only healthcare management application built using a microservices architecture with Spring Boot and Java. The system handles patient data, authentication, and notifications through decoupled services communicating via Kafka and gRPC.

---

## 🚀 Features

- ⚙️ Microservices architecture for scalability and modularity
- 📬 Asynchronous communication between services using Kafka
- 🔗 Efficient RPC via gRPC and Protocol Buffers
- 🔐 API Gateway for unified API exposure
- 🐘 PostgreSQL for persistent storage across services
- 🧪 Integration testing to ensure inter-service reliability
- 🐳 Dockerized for containerized development and deployment

---

## 🧱 Tech Stack

| Tech              | Purpose                                |
|-------------------|----------------------------------------|
| Java              | Core programming language              |
| Spring Boot       | Microservices and REST APIs            |
| PostgreSQL        | Persistent database                    |
| Kafka             | Message queue for async messaging      |
| gRPC              | Lightweight, fast RPC calls            |
| Protocol Buffers  | gRPC message serialization             |
| Docker            | Containerization and environment setup |
| Postman           | API testing and development            |

---

## 📊 System Architecture

![Achitecture Diagram](https://res.cloudinary.com/dngjfx9ln/image/upload/v1744198009/architecture_ydgnwo.png)

> Each service is containerized and communicates via Kafka for event-driven updates and gRPC for synchronous RPC.

---

## 🧪 Running Locally

> You’ll need Docker and Java 17 installed.

```bash
# Step 1: Clone the repository
git clone https://github.com/AryanshTripathi/Patient-Management-System.git
cd Patient-Management-System

# Step 2: Start all services with Docker
docker-compose up --build

# Step 3: Hit the gateway API via Postman (Example)
GET http://localhost:8080/api/patients
```

---

## ✅ API Overview

| Endpoint                   | Method | Description            |
|----------------------------|--------|------------------------|
| `/api/patients`           | GET    | Fetch all patients         |
| `/api/patients`           | POST   | Create a new patient       |
| `/api/patients/{id}`      | PUT    | Update a patient's details |

> More endpoints available via Postman Collection (Coming Soon)

---

## 🧪 Integration Testing

- Tests written using JUnit and Spring Boot Test modules
- Simulates service-to-service communication and Kafka event flows
- Currently includes 3+ integration tests on Auth service

---

## 📌 Project Motivation

The primary objective behind building this project was to gain hands-on experience with **Java**, **Spring Boot**, and real-world **microservices architecture**. It served as a practical learning ground to explore how scalable systems are designed, developed, and containerized using technologies like Kafka, gRPC, and Docker. The project allowed me to apply core backend principles while deepening my understanding of asynchronous communication, service decoupling, and integration testing.

---

## 🙌 Author

**Aryansh Tripathi**  
Final-year student at IIT BHU | Backend & Full-Stack Developer  
[LinkedIn](https://www.linkedin.com/in/aryansh-tripathi-1485aa201/) • [GitHub](https://github.com/AryanshTripathi) • [Portfolio](https://portfolio-eta-smoky-77.vercel.app/)
