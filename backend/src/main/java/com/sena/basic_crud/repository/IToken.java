package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Token;
import com.sena.basic_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IToken extends JpaRepository<Token, Integer> {
    @Query("SELECT t FROM Token t WHERE t.expired = FALSE AND t.locked = FALSE AND t.user.id = :id")
    List<Token> findAllValidTokensByUser(@Param("id") int id);
}
