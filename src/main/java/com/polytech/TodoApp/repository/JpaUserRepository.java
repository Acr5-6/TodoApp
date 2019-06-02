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
    EntityManager entityManager;

    @Override
    public void Add_users(Users user) throws UsernameException {
        if(entityManager.find(Users.class, user.getUsername()) == null) {
            String hash = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(hash);
            entityManager.persist(user);
        } else {
            throw new UsernameException();
        }
    }
}