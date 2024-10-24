Social Media Microservice Project
=================================

This project is a microservice-based social media platform, consisting of multiple services such as **Config Server**, **User Service**, and **Auth Service**. Each service is built with modern technologies and best practices to ensure scalability, flexibility, and ease of maintenance.

Table of Contents
-----------------

*   [Technologies Used](#technologies-used)
    
*   [Architecture Overview](#architecture-overview)
    
*   [Services Overview](#services-overview)
    
    *   [Config Server](#config-server)
        
    *   [User Service](#user-service)
        
    *   [Auth Service](#auth-service)
    

Technologies Used
-----------------

*   **Java 21**
    
*   **Spring Boot 3**
    
*   **Gradle** for dependency management and build automation
    
*   **Feign Client** for service-to-service communication
    
*   **Redis** for caching and session management
    
*   **Docker** for containerization and service orchestration
    

Architecture Overview
---------------------

The application follows a microservice architecture where each service is independent and interacts with others via HTTP requests using Feign Client. Docker is used to manage the deployment and running of the services, ensuring that they operate seamlessly in isolated containers.

Services Overview
-----------------

### Config Server

The **Config Server** centralizes external configurations for all microservices. It helps to manage application properties dynamically across environments, ensuring that configurations can be updated without redeploying services.

*   **Port**: 8888
    
*   **Technologies**: Spring Cloud Config, Git for centralized configuration management
    

### User Service

The **User Service** handles user-related functionalities such as user registration, profile management, and user data retrieval.

*   **Port**: 9091
    
*   **Technologies**: Spring Boot, Redis (for caching user sessions), Feign Client (to communicate with Auth Service)
    

### Auth Service

The **Auth Service** is responsible for authentication and authorization, generating JWT tokens to secure API endpoints.

*   **Port**: 9090
    
*   **Technologies**: Spring Security, JWT (JSON Web Token) for authentication, Redis (for token caching and session management)
