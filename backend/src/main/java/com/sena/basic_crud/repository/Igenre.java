package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Igenre extends JpaRepository<genre, Integer> {
}
