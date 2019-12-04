package com.example.cryter.controller;

import com.example.cryter.domain.Role;
import com.example.cryter.domain.User;
import com.example.cryter.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

/**
 * "Created by : goodlikemax"
 * "Date: "03.12.2019
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFomDb = userRepo.findByUsername(user.getUsername());

        if (userFomDb != null){
            model.put("message", "User exist!");
            return "registration";

        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
