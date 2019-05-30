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
    public void save(Task task1) {
        em.persist(task1);
    }

    @Override
    public List<Task> findAll() {
        Query req = em.createQuery("SELECT t FROM task t ORDER BY t.id DESC");
        return (List<Task>) req.getResultList();
    }


}
