package com.polytech.TodoApp.repository;

import com.polytech.TodoApp.business.Task;

import java.util.List;

public interface TaskRepository {
    void save(Task task1);

    List<Task> findAll();

    void delete_task(int id_task);

    void update_task(int id_task, String newcontent);

    void done(int id);
}
