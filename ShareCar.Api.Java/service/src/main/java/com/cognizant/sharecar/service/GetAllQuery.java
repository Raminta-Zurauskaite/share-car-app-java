package com.cognizant.sharecar.service;

public class GetAllQuery {
    TaskStatus status;

    public GetAllQuery(TaskStatus status) {
        this.status = status;
    }

    public GetAllQuery() {

    }

    public TaskStatus getStatus() {
        return status;
    }
}
