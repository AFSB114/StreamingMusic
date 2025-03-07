package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.playlist_song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Iplaylist_song extends JpaRepository<playlist_song, Integer> {
}
