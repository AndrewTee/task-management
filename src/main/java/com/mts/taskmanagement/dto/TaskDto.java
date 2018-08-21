package com.mts.taskmanagement.dto;

import com.mts.taskmanagement.model.Task;
import com.mts.taskmanagement.model.TaskStatus;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    private TaskStatus status;
    private LocalDateTime timestamp;


    public TaskDto(Task task) {
        status = task.getStatus();
        timestamp = task.getLocalDateTime();
    }
}
