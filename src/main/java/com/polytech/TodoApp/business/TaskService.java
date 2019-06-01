package com.polytech.TodoApp.business;

import java.util.List;

public interface TaskService {
    void add_task(Task task1);
    List<Task> get_Tasks();

    void delete_task(int id_task);

    void update_task(int id_task, String newcontent);
}
