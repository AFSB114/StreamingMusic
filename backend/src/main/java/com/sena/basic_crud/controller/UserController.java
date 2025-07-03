package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.*;
import com.sena.basic_crud.model.User;
import com.sena.basic_crud.projection.UserView;
import com.sena.basic_crud.service.AuthService;
import com.sena.basic_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> registerUser(@RequestBody UserRegister user) {
        System.out.print("Security Filter Chain <UNK>");
        var res = authService.register(user);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> loginUser(@RequestBody UserLogin user) {
        TokenResponse res = authService.login(user);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllUsers() {
        List<UserView> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        ResponseDTO res = userService.findById(id);
        return new ResponseEntity<>(res, res.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        ResponseDTO res = userService.delete(id);
        return new ResponseEntity<>(res, res.getStatus());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id, @ModelAttribute UserDTO user) {
        ResponseDTO res = userService.update(id, user);
        return new ResponseEntity<>(res, res.getStatus());
    }
}
