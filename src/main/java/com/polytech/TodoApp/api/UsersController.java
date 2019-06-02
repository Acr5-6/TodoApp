package com.polytech.TodoApp.api;

import com.polytech.TodoApp.business.RegisterService;
import com.polytech.TodoApp.business.Users;
import com.polytech.TodoApp.exception.UsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UsersController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/registerU")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody Users user)  {
        System.out.println("addUser");
//        registerService.add_Users(user);
        try {
            registerService.add_Users(user);
        } catch (UsernameException e){
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, e.getMessage(), e);
        }

    }
}
