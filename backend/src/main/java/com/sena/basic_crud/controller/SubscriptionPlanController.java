package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SubscriptionPlanDTO;
import com.sena.basic_crud.model.SubscriptionPlan;
import com.sena.basic_crud.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscription-plan")
public class SubscriptionPlanController {

    private final SubscriptionPlanService subscriptionPlanService;

    @Autowired
    public SubscriptionPlanController(SubscriptionPlanService subscriptionPlanService) {
        this.subscriptionPlanService = subscriptionPlanService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addSubscriptionPlan(@ModelAttribute SubscriptionPlanDTO subscriptionPlan) {
        ResponseDTO res = subscriptionPlanService.save(subscriptionPlan);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllSubscriptionPlans() {
        List<SubscriptionPlan> subscriptionPlans = subscriptionPlanService.findAll();
        return new ResponseEntity(subscriptionPlans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSubscriptionPlanById(@PathVariable int id) {
        ResponseDTO res = subscriptionPlanService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteSubscriptionPlan(@PathVariable int id) {
//        ResponseDTO res = subscriptionPlanService.delete(id);
//        return new ResponseEntity(res, res.getStatus());
//    }
}
