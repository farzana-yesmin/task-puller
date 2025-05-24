package com.frai.gmbh.taskpuller.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frai.gmbh.taskpuller.cache.TaskCache;
import com.frai.gmbh.taskpuller.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.UUID;

@Service
@Slf4j
public class TaskService {

    @Value("${task.directory}")
    private String tasksDirectory;

    private final TaskCache taskCache;
    private final ObjectMapper objectMapper;

    public TaskService(TaskCache taskCache, ObjectMapper objectMapper) {
        this.taskCache = taskCache;
        this.objectMapper = objectMapper;
    }

    public Task getTaskById(String id) throws IOException {
        validateUUID(id);

        Task cached = taskCache.get(id);
        if (cached != null) {
            log.info("Found cached task: {}", cached);
            return cached;
        }

        File file = new File(tasksDirectory, id + ".json");
        if (!file.exists() || !file.isFile()) {
            throw new NoSuchFileException("Task file not found");
        }

        Task task = objectMapper.readValue(file, Task.class);
        taskCache.put(id, task);
        return task;
    }


    private void validateUUID(String id) {
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid UUID format");
        }
    }

}
