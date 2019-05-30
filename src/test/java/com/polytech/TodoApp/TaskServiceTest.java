package com.polytech.TodoApp;

import com.polytech.TodoApp.business.Task;
import com.polytech.TodoApp.business.TaskService;
import com.polytech.TodoApp.business.TaskServiceImpl;
import com.polytech.TodoApp.config.AppConfig;
import com.polytech.TodoApp.repository.InMemoryTaskRepository;
import com.polytech.TodoApp.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static java.util.Arrays.asList;

public class TaskServiceTest {

    @Test
    public void should_save_task(){
//        //GIVEN
//        TaskRepository taskRepository = new InMemoryTaskRepository();
//        TaskService taskService= new TaskServiceImpl(taskRepository);
//        Task task1=new Task("faire la vaisselle");
//        Task task2=new Task("la cuisine");
//
//        //WHEN
//        taskService.add_task(task1);
//        taskService.add_task(task2);
//
//        //THEN
//        List<Task> tasks = taskRepository.findAll();
//        Assert.assertEquals(2, tasks.size());
//        Assert.assertEquals(asList(task1, task2), tasks);

        ApplicationContext context = SpringApplication.run(AppConfig.class);
        //GIVEN
        TaskRepository taskRepository = context.getBean(TaskRepository.class);
        TaskService taskService= context.getBean(TaskService.class);
        Task task1=new Task("faire la vaisselle");
        Task task2=new Task("la cuisine");

        //WHEN
        taskService.add_task(task1);
        taskService.add_task(task2);

        //THEN
        List<Task> tasks = taskRepository.findAll();
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(asList(task1, task2), tasks);
    }
}
