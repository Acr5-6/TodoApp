package com.polytech.TodoApp.exception;

public class UsernameException  extends Exception {

    public UsernameException() {
        super("Username already exists. Choose another one !");
    }

}
