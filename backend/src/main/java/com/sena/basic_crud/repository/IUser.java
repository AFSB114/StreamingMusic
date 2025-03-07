package com.sena.basic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.basic_crud.model.User;

public interface IUser extends JpaRepository <User, Integer>{
}
