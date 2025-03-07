package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenre extends JpaRepository<Genre, Integer> {
}
