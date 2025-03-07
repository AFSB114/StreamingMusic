package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Iplaylist extends JpaRepository<playlist, Integer> {
}
