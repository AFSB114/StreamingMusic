package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAlbum extends JpaRepository<Album, Integer>, JpaSpecificationExecutor<Album> {
}
