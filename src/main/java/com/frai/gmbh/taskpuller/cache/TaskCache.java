package com.frai.gmbh.taskpuller.cache;

import com.frai.gmbh.taskpuller.model.Task;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class TaskCache {

    private static final int MAX_CACHE_SIZE = 5;
    private final LinkedHashMap<String, Task> cache;

    public TaskCache () {
        this.cache = new LinkedHashMap<>(MAX_CACHE_SIZE, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Task> eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public synchronized Task get(String id) {
        return cache.get(id);
    }

    public synchronized void put(String id, Task task) {
        cache.put(id, task);
    }
}