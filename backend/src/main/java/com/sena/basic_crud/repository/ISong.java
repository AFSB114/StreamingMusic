package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISong extends JpaRepository<Song, Integer> {
}
