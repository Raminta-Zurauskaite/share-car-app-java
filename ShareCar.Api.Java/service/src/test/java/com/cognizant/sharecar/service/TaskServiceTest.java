package com.cognizant.sharecar.service;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class TaskServiceTest {

    @Test
    public void getAll_NoTaskWereAdded_ReturnEmptyTaskList(){
        TaskService taskService = new DefaultTaskService();

        List<Task> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(0));
    }

    @Test
    public void getAll_OneTaskWereAdded_ReturnOneTask(){
        TaskService taskService = new DefaultTaskService();

        taskService.add(new Task());

        List<Task> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(1));
    }

    @Test
    public void getAll_StatusIsDone_ReturnEmpty(){
        TaskService taskService = new DefaultTaskService();

        taskService.add(new Task());

        List<Task> tasks = taskService.getAll(new GetAllQuery(TaskStatus.DONE));

        assertThat(tasks, hasSize(0));
    }

    @Test
    public void getAll_StatusIsDoneAndTwoTasksWereAdded_OneIsReturned(){
        TaskService taskService = new DefaultTaskService();

        taskService.add(new Task());
        Task doneTask = new Task();
        doneTask.setStatus(TaskStatus.DONE);
        taskService.add(doneTask);

        List<Task> tasks = taskService.getAll(new GetAllQuery(TaskStatus.DONE));

        assertThat(tasks, hasSize(1));
    }
}
