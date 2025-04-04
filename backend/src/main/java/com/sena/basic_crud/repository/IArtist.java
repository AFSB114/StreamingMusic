package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IArtist extends JpaRepository<Artist, Integer>, JpaSpecificationExecutor<Artist> {
}
