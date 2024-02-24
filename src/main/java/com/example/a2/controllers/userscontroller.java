package com.example.a2.controllers;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.a2.models.User;
import com.example.a2.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class userscontroller {
    @Autowired
    private UserRepository userRepo;

    // one for the table 
    @GetMapping("/users/view")
    public String getAllusers(Model model){
        System.out.println("getting all users");
        List<User> users = userRepo.findByOrderByUidAsc();
        model.addAttribute("us", users);
        // us represent user
        return "users/showall";
    }

    // map for the boxes
    @GetMapping("/users/home")
    public String getAllusers2(Model model){
        System.out.println("getting all users");
        List<User> users = userRepo.findByOrderByUidAsc();
        model.addAttribute("user", users);
        return "users/product";
    }


    // added user
    @PostMapping("/users/add")
    public String adduser(@RequestParam Map<String,String> newuser, HttpServletResponse response) {
        System.out.println("add user");
        String newName = newuser.get("name");
        int newWeight = Integer.parseInt(newuser.get("weight"));
        int newHeight = Integer.parseInt(newuser.get("height"));
        String newHaircolour = newuser.get("haircolour");
        Double newGpa = Double.parseDouble(newuser.get("gpa"));
    
        // Pass parameters in the desired order
        userRepo.save(new User(newName, newHeight, newWeight, newHaircolour, newGpa));
        response.setStatus(201);
        return "redirect:/users/home";
    }

    //delete user 
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        userRepo.deleteById(id);
        return "redirect:/users/view";
    }

    // get the edited user 
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        User user = userRepo.findByUid(id);
        System.out.println(id);
        if (user == null) {
            // Handle the case where no user is found for the given UID
            // For example, redirect to a 404 error page or back to the user list with an error message
            return "redirect:/users/view";
        }
        model.addAttribute("edituser", user);
        return "users/edituser"; // Make sure this is the correct name of your Thymeleaf template
    }

    //get the edited info and update it 
    @PostMapping("/users/update")
    public String updateUser(@RequestParam Map<String,String> updateUser){
        System.out.println(updateUser.get("name"));
        int userId = Integer.parseInt(updateUser.get("uid"));;
        User user = userRepo.findByUid(userId);
        if(user != null){
            user.setName(updateUser.get("name"));
            user.setWeight(Integer.parseInt(updateUser.get("weight")));
            user.setHeight(Integer.parseInt(updateUser.get("height")));
            user.setHaircolour(updateUser.get("haircolour"));
            user.setGpa(Double.parseDouble(updateUser.get("gpa")));
            userRepo.save(user);
            return "redirect:/users/view";
        }else{
            return "redirect:/users/error";
        }
    }
}






