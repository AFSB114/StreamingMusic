package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Playback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayback extends JpaRepository<Playback, Integer> {
}
