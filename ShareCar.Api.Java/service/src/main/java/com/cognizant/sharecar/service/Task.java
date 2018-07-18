package com.cognizant.sharecar.service;

public class Task {
    TaskStatus status;

    public Task(TaskStatus status) {
        this.status = status;
    }

    public Task() {

    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
