package com.mts.taskmanagement.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String id) {
        super(String.format("Cannot find task with id %", id));
    }
}
