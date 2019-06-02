package com.polytech.TodoApp.business;

import com.polytech.TodoApp.exception.UsernameException;
import com.polytech.TodoApp.repository.AuthorityRepository;
import com.polytech.TodoApp.repository.UserRepository;

public class RegisterServiceImpl implements RegisterService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    public RegisterServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }


    @Override
    public void add_Users(Users user){
        System.out.println(user);
        System.out.println(user.getUsername() + " " +  user.getPassword() + " " + user.getEnabled());

        Authority authority = new Authority(user.getUsername(), "admin");

        System.out.println(authority);
        System.out.println(authority.getUsername() + " " + authority.getAuthority());

        userRepository.Add_users(user);

        authorityRepository.Add_authority(authority);
    }
}
