package com.polytech.TodoApp.repository;

import com.polytech.TodoApp.business.Task;

import java.util.ArrayList;
import java.util.List;

//Classe pour bdd en memoire pour les tests
public class InMemoryTaskRepository implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void save(Task task1) {
        //add task
        tasks.add(task1);
    }

    @Override
    public List<Task> findAll() {
        //get all tasks
        return tasks;
    }

    @Override
    public void delete_task(int id_task) {
        //delete task
    }

    @Override
    public void update_task(int id_task, String newcontent) {
        //update task
    }
}
