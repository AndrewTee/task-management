package com.mts.taskmanagement.service;

import com.mts.taskmanagement.model.Task;
import com.mts.taskmanagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static com.mts.taskmanagement.model.TaskStatus.*;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskServiceAsync taskServiceAsync;

    public Task getTaskById(String id) {
        return Optional.of(taskRepository.findOne(id)).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public Task saveTask(Task task) throws InterruptedException {
        String id = UUID.randomUUID().toString();
        task
                .setId(id)
                .setStatus(CREATED)
                .setLocalDateTime(Timestamp.valueOf(LocalDateTime.now()));

        return saveAndChangeTask(task);
    }

    private Task saveAndChangeTask(Task task) throws InterruptedException {
        taskRepository.save(task);

        taskServiceAsync.changeTaskStatus(task, RUNNING, 2000);
        taskServiceAsync.changeTaskStatus(task, FINISHED, 122000);

        return task;
    }
}
