package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.GenreDTO;
import com.sena.basic_crud.model.Genre;
import com.sena.basic_crud.repository.IGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private IGenre data;

    public ResponseDTO save(GenreDTO genreDTO) {
        ResponseDTO res;
        List<String> errors = validate(genreDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            Genre genre = convertToModel(genreDTO);
            data.save(genre);
            res = ResponseDTO.ok("Request made successful, new Genre created");
        }
        return res;
    }

    public List<Genre> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Genre> genre = data.findById(id);
        if (genre.isPresent()) {
            res = ResponseDTO.ok("Genre found", genre.get());
        } else {
            res = ResponseDTO.error("Genre with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(GenreDTO genreDTO) {
        List<String> errors = new ArrayList<>();

        // Validar nombre
        if (genreDTO.getName() == null || genreDTO.getName().trim().isEmpty()) {
            errors.add("El nombre es obligatorio");
        } else if (genreDTO.getName().length() > 255) {
            errors.add("El nombre no puede exceder los 255 caracteres");
        }

        return errors;
    }

    public Genre convertToModel(GenreDTO genreDTO) {
        Genre genre = new Genre(
                genreDTO.getName(),
                genreDTO.getDescription(),
                genreDTO.getParentGenreId()
        );
        return genre;
    }
}