package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.ArtistGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistGenre extends JpaRepository<ArtistGenre,Integer> {
}
