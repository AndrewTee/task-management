package com.mts.taskmanagement.controller;

import com.mts.taskmanagement.model.TaskApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TaskControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleExceptionNotFoundEntity(NullPointerException ex) {
        TaskApiError taskApiError = new TaskApiError(HttpStatus.NOT_FOUND, "Cannot find task");

        return buildResponseEntity(taskApiError);
    }

    private ResponseEntity<Object> buildResponseEntity(TaskApiError taskApiError) {
        return new ResponseEntity<>(taskApiError, taskApiError.getStatus());
    }
}
