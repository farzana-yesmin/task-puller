package com.frai.gmbh.taskpuller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Task {
    @JsonProperty("Id")
    private String id;
    private String description;
}