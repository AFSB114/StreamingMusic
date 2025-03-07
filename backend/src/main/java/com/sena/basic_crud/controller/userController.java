package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.userDTO;
import com.sena.basic_crud.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class userController {
    @Autowired
    private userService userService;

    @PostMapping("/")
public ResponseEntity<Object> registerUser(@RequestBody userDTO user) {
        userService.save(user);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
