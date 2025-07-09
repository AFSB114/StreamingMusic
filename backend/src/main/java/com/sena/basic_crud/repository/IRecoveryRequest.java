package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.RecoveryRequest;
import com.sena.basic_crud.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IRecoveryRequest extends JpaRepository<RecoveryRequest, Long> {
    @Query("SELECT r FROM recovery_request r WHERE r.expired = FALSE OR r.locked = FALSE AND r.user.id = :id")
    List<RecoveryRequest> findAllValidTokensByUser(@Param("id") int id);

    @Query("SELECT r FROM recovery_request r WHERE r.token = :token")
    Optional<RecoveryRequest> findByToken(@Param("token") String token);
}
