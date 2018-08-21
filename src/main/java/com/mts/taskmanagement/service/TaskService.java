package com.mts.taskmanagement.service;

import com.mts.taskmanagement.exception.TaskNotFoundException;
import com.mts.taskmanagement.model.Task;
import com.mts.taskmanagement.model.TaskStatus;
import com.mts.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskServiceAsync taskServiceAsync;

    public Task getTaskById(String id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Transactional
    public Task saveTask(Task task) throws InterruptedException {
        String id = UUID.randomUUID().toString();
        task
                .setId(id)
                .setStatus(TaskStatus.CREATED);
        taskServiceAsync.changeTaskStatus(task, TaskStatus.RUNNING, 2000);
        taskServiceAsync.changeTaskStatus(task, TaskStatus.FINISHED, 120000);

        return taskRepository.save(task);
    }
}
