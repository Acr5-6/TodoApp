package com.polytech.TodoApp.business;

import com.polytech.TodoApp.repository.TaskRepository;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add_task(Task task1) {
        taskRepository.save(task1);
    }

    @Override
    public List<Task> get_Tasks() {
        return taskRepository.findAll();
    }

    @Override
    public void delete_task(int id_task) {
        taskRepository.delete_task(id_task);
    }

    @Override
    public void update_task(int id_task, String newcontent) {
        taskRepository.update_task(id_task,newcontent);

    }
}
