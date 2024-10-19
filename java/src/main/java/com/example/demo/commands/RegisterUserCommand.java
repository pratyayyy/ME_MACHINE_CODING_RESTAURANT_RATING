package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

public class RegisterUserCommand implements ICommand{
  
    UserService userService; 
    
    public RegisterUserCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public void invoke(List<String> tokens){
        String userName = tokens.get(1);
        User user = userService.registerUser(userName);
        System.out.println(user);
    }

}
