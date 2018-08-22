package com.mts.taskmanagement.controller;

import com.mts.taskmanagement.dto.TaskDto;
import com.mts.taskmanagement.model.Task;
import com.mts.taskmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        return new TaskDto(task);
    }

    @PostMapping
    public ResponseEntity<String> saveTask(@RequestBody @Valid Task task) throws InterruptedException {
        String id = taskService.saveTask(task).getId();
        return new ResponseEntity<String>(id, HttpStatus.ACCEPTED);
    }
}
