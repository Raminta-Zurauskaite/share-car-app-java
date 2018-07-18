package com.cognizant.sharecar.service;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class TaskServiceTest {

    private TaskService taskService;

    @Before
    public void setUp() {
        taskService = new DefaultTaskService();
    }

    @Test
    public void getAll_NoTaskWereAdded_ReturnEmptyTaskList(){

        List<Task> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(0));
    }

    @Test
    public void getAll_OneTaskWereAdded_ReturnOneTask(){

        taskService.add(new Task());

        List<Task> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(1));
    }

    @Test
    public void getAll_StatusIsDone_ReturnEmpty(){
        setUp();

        taskService.add(new Task());

        List<Task> tasks = taskService.getAll(new GetAllQuery(TaskStatus.DONE));

        assertThat(tasks, hasSize(0));
    }

    @Test
    public void getAll_StatusIsDoneAndTwoTasksWereAdded_OneIsReturned(){
        setUp();

        taskService.add(new Task());
        addTask(TaskStatus.DONE);

        List<Task> tasks = taskService.getAll(new GetAllQuery(TaskStatus.DONE));

        assertThat(tasks, hasSize(1));
    }

    @Test
    public void getAll_TwoTasksWereAddedAndStatusIsAbsent_ReturnTwoTasks(){
        setUp();

        TaskStatus done = TaskStatus.DONE;
        taskService.add(new Task());
        addTask(done);

        List<Task> tasks = taskService.getAll(new GetAllQuery());

        assertThat(tasks, hasSize(2));
    }

    private void addTask(TaskStatus done) {
        Task doneTask = new Task();
        doneTask.setStatus(done);
        taskService.add(doneTask);
    }
}
