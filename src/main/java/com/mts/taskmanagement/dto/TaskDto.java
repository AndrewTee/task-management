package com.mts.taskmanagement.dto;

import com.mts.taskmanagement.model.Task;
import com.mts.taskmanagement.model.TaskStatus;
import lombok.Data;

@Data
public class TaskDto {
    private TaskStatus status;
    private String timestamp;

    public TaskDto(Task task) {
        status = task.getStatus();
        timestamp = task.getLocalDateTime().toInstant().toString();
    }
}
