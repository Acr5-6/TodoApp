package com.polytech.TodoApp.repository;

import com.polytech.TodoApp.business.Users;
import com.polytech.TodoApp.exception.UsernameException;

public interface UserRepository {
    void Add_users(Users user);
}
