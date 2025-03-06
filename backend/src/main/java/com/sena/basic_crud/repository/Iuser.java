package com.sena.basic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.basic_crud.model.user_account;

public interface Iuser extends JpaRepository <user_account, Integer>{
}
