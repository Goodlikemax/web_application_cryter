package com.example.cryter.controller;

import com.example.cryter.domain.Message;
import com.example.cryter.domain.User;
import com.example.cryter.repos.MessageRepo;
import com.example.cryter.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * "Created by : goodlikemax"
 * "Date: "01.12.2019
 */

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model){
      return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user,
                       Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findByTag(user.getUsername());

        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model){

        User userFomDb = userRepo.findByUsername(tag);

        if (userFomDb == null){
            model.put("message", "User not exist!");


        }else {


            Message message = new Message(text, tag, user);

            messageRepo.save(message);
        }
            Iterable<Message> messages = messageRepo.findByTag(user.getUsername());

            model.put("messages", messages);

            return "main";

    }

//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable<Message> messages;
//
//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        }else {
//            messages = messageRepo.findAll();
//        }
//
//        model.put("messages", messages);
//
//        return "main";
//    }
}
