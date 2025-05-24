package com.frai.gmbh.taskpuller.controller;

import com.frai.gmbh.taskpuller.model.Task;
import com.frai.gmbh.taskpuller.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getTask/{id}")
    public Task getTask(@PathVariable String id) throws IOException {
        return taskService.getTaskById(id);
    }
}
