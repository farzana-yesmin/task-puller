# 📋 Task Retrieval API with Caching

A Spring Boot-based RESTful API that retrieves task details from the filesystem and serves them through an endpoint. It includes an in-memory LRU cache and robust exception handling.

---

## 🚀 Features

- ✅ Retrieve task data by ID from JSON files
- 🧠 LRU in-memory caching (Least Recently Used)
- ❌ Graceful error handling for:
    - Invalid UUIDs
    - Missing task files
    - Malformed JSON
    - Unexpected internal errors
- 🔧 Configurable task file directory via application properties

---

## 📦 Dependencies

- Spring Boot Web
- Lombok
- Spring Boot Test (for unit/integration testing)

---

## ⚙️ Configuration

In `application.properties`, set the directory where task files are stored:

```properties
task.directory=src/main/resources/tasks

🧪 How to Run

- Clone the repository

- Add task JSON files to the configured directory

- Run the application :
    ./mvnw spring-boot:run
    
- Access the endpoint:
    GET http://localhost:8080/getTask/{id}

