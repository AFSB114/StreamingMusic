package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Token;
import com.sena.basic_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IToken extends JpaRepository<Token, Integer> {
    @Query("SELECT t FROM Token t WHERE t.expired = FALSE OR t.locked = FALSE AND t.user.id = :id")
    List<Token> findAllValidTokensByUser(@Param("id") int id);

    @Query("SELECT t FROM Token t WHERE t.token = :token")
    Optional<Token> findByToken(@Param("token") String token);
}
