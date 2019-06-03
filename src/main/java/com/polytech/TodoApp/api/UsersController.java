package com.polytech.TodoApp.api;

import com.polytech.TodoApp.business.RegisterService;
import com.polytech.TodoApp.business.Users;
import com.polytech.TodoApp.exception.UsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UsersController {

    @Autowired
    RegisterService registerService;


    @PostMapping("/registerU")
    public void register(@RequestBody Users user)  throws UsernameException{
        System.out.println("addUser");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        registerService.add_Users(user);
    }

}
