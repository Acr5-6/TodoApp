package com.polytech.TodoApp.business;

import com.polytech.TodoApp.repository.TaskRepository;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add_task(Task task1) {
        taskRepository.save(task1);
    }
}
