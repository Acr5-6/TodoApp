package com.polytech.TodoApp;

import com.polytech.TodoApp.business.Task;
import com.polytech.TodoApp.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import com.polytech.TodoApp.config.AppConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        //Test d'ajout et d'affichage des données dans la base
//        ApplicationContext context = SpringApplication.run(AppConfig.class);
//        TaskRepository taskRepository = context.getBean(TaskRepository.class);
//        taskRepository.save(new Task("la vaisselle"));
//        taskRepository.save(new Task("la cuisine"));
//        taskRepository.save(new Task("le menage"));
//
//        List<Task> tasks = taskRepository.findAll();
//        for (Task task : tasks) {
//            System.out.println(task.toString());
//        }

        String hash = new BCryptPasswordEncoder().encode("alix");
        System.out.println(hash);
    }
}
