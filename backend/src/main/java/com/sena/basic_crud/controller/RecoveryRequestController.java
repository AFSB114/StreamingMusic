package com.sena.basic_crud.controller;

import com.sena.basic_crud.service.RecoveryRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recovery-request")
@RequiredArgsConstructor
public class RecoveryRequestController {

    private final RecoveryRequestService recoveryRequestService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecoveryRequestById(@PathVariable Long id) {
        var res = recoveryRequestService.findById(id);
        return ResponseEntity.ok(res);
    }
}
