package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Iartist extends JpaRepository<artist, Integer> {
}
