package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ialbum extends JpaRepository<album, Integer> {
}
