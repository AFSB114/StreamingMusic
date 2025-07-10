package com.sena.basic_crud.service;

import com.sena.basic_crud.model.RecoveryRequest;
import com.sena.basic_crud.model.Token;
import com.sena.basic_crud.model.User;
import com.sena.basic_crud.repository.IRecoveryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecoveryRequestService {
    private final IRecoveryRequest recoveryRequestRepository;

    public RecoveryRequest findById(Long id) {
        return recoveryRequestRepository.findById(id).orElse(null);
    }

    public void revokeAllUserToken(User user){
        List<RecoveryRequest> validUserTokens = recoveryRequestRepository.findAllValidTokensByUser(user.getId());
        if (validUserTokens.isEmpty()) return;
        System.out.println("Revoke All User Tokens");
        for (RecoveryRequest recoveryRequest : validUserTokens) {
            recoveryRequest.setExpired(true);
            recoveryRequest.setLocked(true);
        }
        recoveryRequestRepository.saveAll(validUserTokens);
    }

    public void revokeUserToken(String token){
        RecoveryRequest recoveryRequest = recoveryRequestRepository.findByToken(token).orElse(null);
        if (recoveryRequest == null) throw new UsernameNotFoundException("Invalid email or password");

        recoveryRequest.setExpired(false);
        recoveryRequest.setLocked(false);
        recoveryRequestRepository.save(recoveryRequest);
    }
}
