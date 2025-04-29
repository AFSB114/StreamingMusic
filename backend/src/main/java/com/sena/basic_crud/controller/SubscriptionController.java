package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SubscriptionDTO;
import com.sena.basic_crud.model.Subscription;
import com.sena.basic_crud.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addSubscription(@RequestBody SubscriptionDTO subscription) {
        ResponseDTO res = subscriptionService.save(subscription);
        return new ResponseEntity<>(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.findAll();
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSubscriptionById(@PathVariable int id) {
        ResponseDTO res = subscriptionService.findById(id);
        return new ResponseEntity<>(res, res.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSubscription(@PathVariable int id) {
        ResponseDTO res = subscriptionService.delete(id);
        return new ResponseEntity<>(res, res.getStatus());
    }
}