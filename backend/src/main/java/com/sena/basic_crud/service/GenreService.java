package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.GenreDTO;
import com.sena.basic_crud.model.Genre;
import com.sena.basic_crud.repository.IGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    private IGenre data;

    public void save(GenreDTO genreDTO) {
        Genre genre = convertToModel(genreDTO);
        data.save(genre);
    }

    public Genre convertToModel(GenreDTO genreDTO) {
        return new Genre(
                genreDTO.getId(),
                genreDTO.getName(),
                genreDTO.getDescription(),
                genreDTO.getParentGenreId()
        );
    }

    public GenreDTO convertToDTO(Genre genre) {
        return new GenreDTO(
                genre.getId(),
                genre.getName(),
                genre.getDescription(),
                genre.getParentGenreId()
        );
    }
}
