package com.polytech.TodoApp.business;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {

    @Id
    @Column(name="idtask")
    private int id;

    @Column(name = "content")
    private String content;

//    @ManyToOne
//    private Users user;

    @Column(name = "user")
    private String username;

    @Column(name = "done")
    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Task(){}

    public Task(int id, String content, String username) {
        this.id = id;
        this.content = content;
        this.username = username;
    }

    public Task(String taskname) {

        this.content = taskname;
    }

    public Task(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Task(String content, String name) {
        this.content=content;
        this.username=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + username +
                '}';
    }
}
