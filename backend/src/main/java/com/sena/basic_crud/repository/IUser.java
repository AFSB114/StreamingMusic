package com.sena.basic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.basic_crud.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUser extends JpaRepository <User, Integer>{
    @Modifying
    @Transactional
    @Query("UPDATE user_account u SET u.isActive = FALSE WHERE u.id = :id ")
    void deleteById(int id);

    @Query("SELECT u FROM user_account u WHERE u.isActive = true")
    List<User> findAllActive();

    @Query("SELECT u FROM user_account u WHERE u.isActive = false")
    List<User> findAllInactive();

}
