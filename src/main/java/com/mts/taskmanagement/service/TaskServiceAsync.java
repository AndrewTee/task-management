package com.mts.taskmanagement.service;

import com.mts.taskmanagement.model.Task;
import com.mts.taskmanagement.model.TaskStatus;
import com.mts.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceAsync {
    private final TaskRepository taskRepository;

    @Async
    public void changeTaskStatus(Task task, TaskStatus taskStatus, long delay) throws InterruptedException {
        Thread.sleep(delay);
        task.setStatus(taskStatus);
        taskRepository.save(task);
    }
}
