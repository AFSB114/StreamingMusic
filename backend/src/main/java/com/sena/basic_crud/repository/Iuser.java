package com.sena.basic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.basic_crud.model.user;

public interface Iuser extends JpaRepository <user, Integer>{
}
