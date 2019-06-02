package com.polytech.TodoApp.repository;

import com.polytech.TodoApp.business.Users;
import com.polytech.TodoApp.exception.UsernameException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void Add_users(Users user) {
//        if(em.find(Users.class, user.getUsername()) == null) {
//            String hash = new BCryptPasswordEncoder().encode(user.getPassword());
//            user.setPassword(hash);
//            em.persist(user);
//        } else {
//            throw new UsernameException();
//        }
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hash);
        em.persist(user);
    }
}