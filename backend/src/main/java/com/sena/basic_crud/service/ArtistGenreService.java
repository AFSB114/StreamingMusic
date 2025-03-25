package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.ArtistGenreDTO;
import com.sena.basic_crud.model.ArtistGenre;
import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.model.Genre;
import com.sena.basic_crud.repository.IArtistGenre;
import com.sena.basic_crud.repository.IArtist;
import com.sena.basic_crud.repository.IGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistGenreService {
    @Autowired
    private IArtistGenre data;

    @Autowired
    private IArtist artistRepository;

    @Autowired
    private IGenre genreRepository;

    public ResponseDTO save(ArtistGenreDTO artistGenreDTO) {
        ResponseDTO res;
        List<String> errors = validate(artistGenreDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            ArtistGenre artistGenre = convertToModel(artistGenreDTO);
            data.save(artistGenre);
            res = ResponseDTO.ok("Request made successful, new ArtistGenre created");
        }
        return res;
    }

    public List<ArtistGenre> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<ArtistGenre> artistGenre = data.findById(id);
        if (artistGenre.isPresent()) {
            res = ResponseDTO.ok("ArtistGenre found", artistGenre.get());
        } else {
            res = ResponseDTO.error("ArtistGenre with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(ArtistGenreDTO artistGenreDTO) {
        List<String> errors = new ArrayList<>();

        // Validar artista
        if (artistGenreDTO.getArtistId() == null) {
            errors.add("El ID del artista es obligatorio");
        } else if (!artistRepository.existsById(artistGenreDTO.getArtistId().getId())) {
            errors.add("El artista con ID " + artistGenreDTO.getArtistId() + " no existe");
        }

        // Validar género
        if (artistGenreDTO.getGenreId() == null) {
            errors.add("El ID del género es obligatorio");
        } else if (!genreRepository.existsById(artistGenreDTO.getGenreId().getId())) {
            errors.add("El género con ID " + artistGenreDTO.getGenreId() + " no existe");
        }

        return errors;
    }

    public ArtistGenre convertToModel(ArtistGenreDTO artistGenreDTO) {
        Artist artist = artistRepository.findById(artistGenreDTO.getArtistId().getId()).orElse(null);
        Genre genre = genreRepository.findById(artistGenreDTO.getGenreId().getId()).orElse(null);

        return new ArtistGenre(artist, genre);
    }
}
