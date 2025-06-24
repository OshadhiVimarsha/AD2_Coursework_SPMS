# Smart Parking Management System (SPMS)

## Project Overview

The Smart Parking Management System (SPMS) is a microservice-based platform designed to address the challenges of urban parking. It enables users to find and reserve parking spots in real time while allowing parking owners to manage their spaces efficiently.

---

## Features

- User registration and authentication  
- Real-time parking space availability  
- Vehicle registration and simulation of entry/exit  
- Digital payment processing with receipt generation  
- Service discovery and centralized config with Spring Cloud  
- API Gateway for routing all requests  
- Dockerized services and MySQL database  
- Postman-tested backend APIs (no frontend required)

---

## Getting Started

### Prerequisites

- Java 17+  
- Maven  
- Docker & Docker Compose  
- MySQL (or use Docker container)  
- Postman

### Running the Application

1. Clone the repository:

```bash
git clone https://github.com/OshadhiVimarsha/AD2_Coursework_SPMS.git
cd spms
```
2. Start the Docker containers:
```bash
docker-compose up --build
```
### 3. Access Services

- **Eureka Dashboard:** [http://localhost:8761](http://localhost:8761)  
- **API Gateway:** [http://localhost:8080](http://localhost:8080)
- **Config Server:** [http://localhost:8888](http://localhost:8888)

The API documentation is available in the Postman collection: [Postman Collection](https://raw.githubusercontent.com/OshadhiVimarsha/AD2_Coursework_SPMS/49f6e00c3a2442e87c38b3c9674746138b9ff27f/docs/postman-collection/Ad2_Coursework.postman_collection.json)


- This collection includes detailed requests and responses for all major features:
  - User registration, login, and profile management
  - Vehicle registration and entry/exit simulation
  - Parking space listing, reservation, and release
  - Payment processing and receipt generation
- Import the collection into Postman to explore and test each endpoint.


---

## Project Structure

![image](https://github.com/user-attachments/assets/97ecce08-2a82-4554-9d8c-e42e7121436e)


---

## Eureka Dashboard

Below is a screenshot showing all microservices registered with Eureka:

![image](https://github.com/user-attachments/assets/ed521474-a84c-4f75-b5a1-2ff06ee573f5)





