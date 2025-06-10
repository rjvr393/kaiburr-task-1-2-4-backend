# Kaiburr Task 1 and 2 - Backend Submission

## Description
This is a Spring Boot backend application built for Kaiburr Assessment Task 1.

It allows:
- Creating shell-based tasks
- Executing commands
- Storing output and execution details in MongoDB

## Technologies Used
- Java 17 (OpenJDK 24)
- Spring Boot 3.5.0
- MongoDB (running locally on localhost:27017)
- Postman (for testing APIs)

## How to Run
1. Ensure MongoDB is running on your system
2. Open the project in IntelliJ
3. Run TaskbackendApplication.java
4. Use Postman to test the API

## API Endpoints

| Method | Endpoint                      | Description             |
|--------|-------------------------------|-------------------------|
| PUT    | /tasks                      | Create a new task       |
| PUT    | /tasks/{id}/execute         | Execute a task command  |
| GET    | /tasks                      | Get all tasks           |
| GET    | /tasks/search?name=xyz      | Search tasks by name    |
| GET    | /tasks/{id}                 | Get task by ID          |
| DELETE | /tasks/{id}                 | Delete a task           |

## Sample Output

```json
{
  "id": "task001",
  "name": "Print Hello",
  "owner": "Jai",
  "command": "echo Hello Kaiburr",
  "taskExecutions": [
    {
      "startTime": "...",
      "endTime": "...",
      "output": "Hello Kaiburr"
    }
  ]
}