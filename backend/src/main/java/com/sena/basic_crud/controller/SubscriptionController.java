package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.SubscriptionDTO;
import com.sena.basic_crud.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/")
    private ResponseEntity<Object> registerSubscription(@RequestBody SubscriptionDTO subscription) {
        subscriptionService.save(subscription);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
