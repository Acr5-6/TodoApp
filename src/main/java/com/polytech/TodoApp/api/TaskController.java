package com.polytech.TodoApp.api;

import com.polytech.TodoApp.business.Task;
import com.polytech.TodoApp.business.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping("/getTasks")
    public List<Task> getTasks(){
        System.out.println("getTasks");
        return taskService.get_Tasks();
    }

    @PostMapping("/addTask")
    public void addTask(@RequestBody String content){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("addTask");
        taskService.add_task(new Task(content, authentication.getName()));
    }

    @DeleteMapping("/deleteTask/{idtask}")
    public void deletetask(@PathVariable("idtask") int id_task){
        System.out.println("deleteTask");
        taskService.delete_task(id_task);
    }

    @PutMapping("/updateTask/{idtask}/{newContent}")
    public void update(@PathVariable("idtask") int id_task, @PathVariable("newContent") String newcontent) {
        System.out.println("updateTask");
        taskService.update_task(id_task, newcontent);
    }

    @PostMapping("/done")
    public void done(@RequestBody int id) {
        taskService.done(id);
    }

}
