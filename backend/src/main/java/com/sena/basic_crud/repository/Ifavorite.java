package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ifavorite extends JpaRepository<favorite, Integer> {
}
