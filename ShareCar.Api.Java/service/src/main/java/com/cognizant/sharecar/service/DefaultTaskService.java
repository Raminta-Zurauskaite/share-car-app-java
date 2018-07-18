package com.cognizant.sharecar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultTaskService implements TaskService {

    List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getAll(GetAllQuery getAllQuery) {

        TaskStatus status = getAllQuery.getStatus();

        return tasks.stream().filter(task -> task.getStatus() == status).collect(Collectors.toList());
    }

    @Override
    public void add(Task task) {
        tasks.add(task);
    }
}
