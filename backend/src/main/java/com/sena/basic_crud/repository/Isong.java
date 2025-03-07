package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Isong extends JpaRepository<song, Integer> {
}
