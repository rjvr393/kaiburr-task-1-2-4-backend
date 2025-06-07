package com.kaiburr.taskbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @PutMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createOrUpdateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String name) {
        return taskService.searchTasksByName(name);
    }

    @PutMapping("/{id}/execute")
    public Task runCommand(@PathVariable String id) {
        return taskService.executeCommand(id);
    }
}
