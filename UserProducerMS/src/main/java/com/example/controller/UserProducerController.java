package com.example.controller;

import com.example.Model.User;
import com.example.sevice.UserProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProducerController {
    @Autowired
    private UserProducerService userProducerService;
    @PostMapping("/publish")
    ResponseEntity<String> sendProducerMessageToKafka(@RequestBody User user){
        userProducerService.publishMessage(user);
        return ResponseEntity.ok("User Details send to Kafka Successfully");
    }
}
