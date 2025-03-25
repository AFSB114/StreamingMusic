package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SongGenreDTO;
import com.sena.basic_crud.model.SongGenre;
import com.sena.basic_crud.repository.ISongGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongGenreService {
    @Autowired
    private ISongGenre data;

    public ResponseDTO save(SongGenreDTO songGenreDTO) {
        ResponseDTO res;
        List<String> errors = validate(songGenreDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            SongGenre songGenre = convertToModel(songGenreDTO);
            data.save(songGenre);
            res = ResponseDTO.ok("Request made successful, new SongGenre created");
        }
        return res;
    }

    public List<SongGenre> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<SongGenre> songGenre = data.findById(id);
        if (songGenre.isPresent()) {
            res = ResponseDTO.ok("SongGenre found", songGenre.get());
        } else {
            res = ResponseDTO.error("SongGenre with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(SongGenreDTO songGenreDTO) {
        List<String> errors = new ArrayList<>();

        // Validar canción
        if (songGenreDTO.getSongId() == null) {
            errors.add("La canción es obligatoria");
        }

        // Validar género
        if (songGenreDTO.getGenreId() == null) {
            errors.add("El género es obligatorio");
        }

        return errors;
    }

    public SongGenre convertToModel(SongGenreDTO songGenreDTO) {
        SongGenre songGenre = new SongGenre(
                songGenreDTO.getSongId(),
                songGenreDTO.getGenreId()
        );
        return songGenre;
    }
}