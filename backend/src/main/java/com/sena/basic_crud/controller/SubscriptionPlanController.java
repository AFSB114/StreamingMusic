package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.SubscriptionPlanDTO;
import com.sena.basic_crud.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscription-plan")
public class SubscriptionPlanController {
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @PostMapping("/")
    private ResponseEntity<Object> registerSubscriptionPlan(@RequestBody SubscriptionPlanDTO subscriptionPlan) {
        subscriptionPlanService.save(subscriptionPlan);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
