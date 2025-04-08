package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IGenre extends JpaRepository<Genre, Integer>, JpaSpecificationExecutor<Genre> {
}
