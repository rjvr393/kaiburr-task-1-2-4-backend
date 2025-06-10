This is my local updated README content with Task 1, 2, and 4.


**Author:** Jai (GitHub: [rjvr393](https://github.com/rjvr393))  
**Submitted for:** Kaiburr Technical Assessment  
**Date:** June 2025  
**Repo:** https://github.com/rjvr393/kaiburr-task4 (for CI/CD, includes backend and K8s)

---

## ✅ Overview

This repository contains my solution for the following Kaiburr 2025 assessment tasks:

- **Task 1:** Java backend with REST APIs and MongoDB integration
- **Task 2:** Docker + Kubernetes deployment with shell command execution inside K8s pods
- **Task 4:** CI/CD pipeline using GitHub Actions (builds and packages the backend app automatically)

All relevant screenshots are available in the `screenshots/` folder, including:
- API testing in Postman
- Kubernetes pods/services output
- GitHub Actions workflow logs
- System clock + name visible in all

---

## 📦 Task 1 – Java Backend (Spring Boot + MongoDB)

This is a Spring Boot REST API that allows creation, deletion, search, and execution of "Task" objects. Each task contains:

- `id`, `name`, `owner`, `command`
- A list of `taskExecutions` which include start/end timestamps and shell output

### 🔧 Technologies Used:
- Java 17
- Spring Boot
- MongoDB (local and Kubernetes deployment)
- Postman for API testing

### 🔗 API Endpoints:

| Method | Endpoint                  | Description              |
|--------|---------------------------|--------------------------|
| GET    | `/tasks`                  | Get all tasks            |
| GET    | `/tasks?id=123`           | Get task by ID           |
| GET    | `/tasks/search?name=abc`  | Search tasks by name     |
| PUT    | `/tasks`                  | Create/update a task     |
| DELETE | `/tasks/{id}`             | Delete a task            |
| PUT    | `/tasks/{id}/execute`     | Execute command in K8s   |

---

## 🚢 Task 2 – Kubernetes Deployment

### ✅ What I Deployed:
- Spring Boot app containerized with Docker
- MongoDB deployed in its own pod
- Backend configured to connect to MongoDB via env vars
- `task execution` endpoint creates a new **Kubernetes pod** to run the command (uses `busybox`)
- MongoDB uses a **PersistentVolumeClaim** for durable data

### 🔧 Tools Used:
- Minikube (single-node cluster)
- kubectl
- Kubernetes manifests (`k8s/` folder)
- Helm (optional for MongoDB)
- NodePort service to expose backend

### 🧪 Verifications:
- `kubectl get pods/services`
- `curl` test to API from host
- Task creation + execution through pods confirmed

---

## ⚙️ Task 4 – CI/CD Pipeline (GitHub Actions)

This repo is dedicated to the CI/CD setup using **GitHub Actions**.

### ✅ Workflow Summary:
- Triggers on every push to `main`
- Builds Spring Boot app using Maven
- Builds Docker image from the backend folder
- Future-ready for Docker push or Kubernetes deploy (can be added)

### 📂 Location:
- `.github/workflows/kaiburr-ci.yml`

### 🧪 Verified via:
- GitHub Actions log showing successful Maven build and Docker image creation
- Screenshot included of the full pipeline log with my name and system time

---

## 📁 File Structure


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
