package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.GenreDTO;
import com.sena.basic_crud.model.Genre;
import com.sena.basic_crud.repository.IGenre;
import com.sena.basic_crud.specification.GenreSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
            res = ResponseDTO.ok("Request made successful, new Genre created", genre);
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

    public ResponseDTO search(String name) {
        Specification<Genre> spec = Specification.where(GenreSpecification.hasName(name));
        List<Genre> Genres = data.findAll(spec);
        return ResponseDTO.ok("Genres found", Genres);
    }

    public ResponseDTO delete(int id) {
        Optional<Genre> genre = data.findById(id);
        if (!genre.isPresent()) return ResponseDTO.error("Genre with id: " + id + " not found");
        data.deleteById(id);
        return ResponseDTO.ok("Genre deleted", genre.get());
    }

    public ResponseDTO update(int id, GenreDTO genreDTO) {
        Optional<Genre> optionalGenre = data.findById(id);

        if (!optionalGenre.isPresent())
            return ResponseDTO.error("Genre with id: " + id + " not found");

        Genre currentGenre = optionalGenre.get();

        currentGenre.setName(genreDTO.getName() != null ? genreDTO.getName() : currentGenre.getName());
        currentGenre.setDescription(genreDTO.getDescription() != null ? genreDTO.getDescription() : currentGenre.getDescription());

        data.save(currentGenre);

        return ResponseDTO.ok("Genre updated", currentGenre);
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
                genreDTO.getDescription()
        );
        return genre;
    }
}