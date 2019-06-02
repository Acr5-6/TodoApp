package com.polytech.TodoApp.repository;

import com.polytech.TodoApp.business.Authority;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JpaAuthorityRepository implements AuthorityRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void Add_authority(Authority authority) {
        entityManager.persist(authority);
    }
}
