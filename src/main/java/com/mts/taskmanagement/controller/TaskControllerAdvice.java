package com.mts.taskmanagement.controller;

import com.mts.taskmanagement.model.TaskApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TaskControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleExceptionInternal(EntityNotFoundException ex) {
        TaskApiError taskApiError = new TaskApiError(HttpStatus.NOT_FOUND, ex.getMessage());

        return buildResponseEntity(taskApiError);
    }

    private ResponseEntity<Object> buildResponseEntity(TaskApiError taskApiError) {
        return new ResponseEntity<>(taskApiError, taskApiError.getStatus());
    }
}
