package com.example.a2.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.a2.models.User;

@Controller
public class userscontroller {
    @GetMapping("/users/view")
    public String getAllusers(){
        System.out.println("getting all users");
        List<User> users = new ArrayList<>();
        users.add(new User("Bobby", 150, 30, "red", 2.5));
        users.add(new User("Steve", 200, 30, "blue", 3.6));
        users.add(new User("Dan", 120, 50, "green", 4.0));
        // change it to database latter
    
        return "users/showall";
    }
}
