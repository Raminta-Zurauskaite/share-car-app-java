package com.cognizant.sharecar.service;

import java.util.ArrayList;
import java.util.List;

public interface TaskService {
    List<Task> getAll(GetAllQuery getAllQuery);

    void add(Task task);
}
