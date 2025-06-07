package com.kaiburr.taskbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(String id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public Task createOrUpdateTask(Task task) {
        validateCommand(task.getCommand());
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public List<Task> searchTasksByName(String name) {
        return taskRepository.findByNameContainingIgnoreCase(name);
    }

    public Task executeCommand(String id) {
        Task task = getTaskById(id);
        if (task == null) return null;

        try {
            Date start = new Date();

            // Run shell command
            String[] command = { "cmd.exe", "/c", task.getCommand() };
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.lines().collect(Collectors.joining("\n"));

            process.waitFor();
            Date end = new Date();

            // Save execution result
            TaskExecution execution = new TaskExecution(start, end, output);
            task.getTaskExecutions().add(execution);

            return taskRepository.save(task);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void validateCommand(String cmd) {
        if (cmd.contains("rm") || cmd.contains("shutdown") || cmd.contains("del")) {
            throw new RuntimeException("⚠️ Dangerous command detected!");
        }
    }
}
