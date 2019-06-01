package com.polytech.TodoApp.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {

    @Id
    @Column(name="idtask")
    private int id;

    @Column(name = "content")
    private String content;

    public Task(){}

    public Task(String taskname) {

        this.content = taskname;
    }

    public Task(int id, String content) {
        this.id = id;
        this.content = content;
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

    @Override
    public String toString() {
        return "Task {" +
                "content='" + content + '\'' +
                '}';
    }
}
