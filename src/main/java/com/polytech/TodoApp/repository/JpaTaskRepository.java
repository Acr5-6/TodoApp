package com.polytech.TodoApp.repository;

import com.polytech.TodoApp.business.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaTaskRepository implements TaskRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Task> findAll() {
        Query req = em.createQuery("SELECT t FROM Task t ORDER BY t.id DESC");
        return (List<Task>) req.getResultList();
    }

    @Override
    public void save(Task task1) {
        em.persist(task1);
    }

    @Override
    public void delete_task(int id_task) {
        Task task= em.getReference(Task.class, id_task);
        em.remove(task);
    }

    @Override
    public void update_task(int id_task, String newcontent) {
        Task updateTask = em.find(Task.class, id_task);
//        updateTask.setDone(task.isDone());
        updateTask.setContent(newcontent);

    }


}
