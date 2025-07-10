package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.RecoveryPassDTO;
import com.sena.basic_crud.DTO.TokenResponse;
import com.sena.basic_crud.DTO.UserLogin;
import com.sena.basic_crud.DTO.UserRegister;
import com.sena.basic_crud.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> registerUser(@RequestBody UserRegister user) {
        var res = authService.register(user);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> loginUser(@RequestBody UserLogin user) {
        TokenResponse res = authService.login(user);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/recovery-pass")
    public ResponseEntity<?> recoveryPassUser(@RequestBody RecoveryPassDTO recoveryPass) {
        System.out.println("Recovery Pass Request");
        var res = authService.recoveryPass(recoveryPass);
        return ResponseEntity.ok(res);
    }
}
