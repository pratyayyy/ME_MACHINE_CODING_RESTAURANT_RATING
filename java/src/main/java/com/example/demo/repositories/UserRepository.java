package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository{

    Map<Long, User> userMap;
    private Long counter = 1L;

    public UserRepository(){
        userMap = new HashMap<Long, User>();
    }

    @Override
    public User save(User user){
        if(user.getId()==null){
            User u = new User(counter,user.getName());
            userMap.put(u.getId(),u);
            counter++;
            return u;
        }
        userMap.put(user.getId(),user);
        return user;
    }
}
