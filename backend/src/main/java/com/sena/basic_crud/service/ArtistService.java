package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ArtistDTO;
import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.repository.IArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private IArtist artistRepository;

    public ResponseDTO save(ArtistDTO artistDTO) {
        ResponseDTO res;
        Artist artist = convertToModel(artistDTO);
        List<String> errors = validate(artist);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {

            artistRepository.save(artist);
            res = ResponseDTO.ok("Request made successful, new Artist created");
        }
        return res;
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isPresent()) {
            res = ResponseDTO.ok("Artist found", artist.get());
        } else {
            res = ResponseDTO.error("Artist with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(Artist artist) {
        List<String> errors = new ArrayList<>();

        if (artist.getName() == null || artist.getName().trim().isEmpty()) {
            errors.add("El nombre del artista es obligatorio");
        }

        if (artist.getImageUrl() == null || artist.getImageUrl().trim().isEmpty()) {
            errors.add("La URL de la imagen del artista es obligatoria");
        }

        return errors;
    }

    public Artist convertToModel(ArtistDTO artistDTO) {
        Artist artist = new Artist(
                artistDTO.getName(),
                artistDTO.getType(),
                artistDTO.getCountryOfOrigin(),
                artistDTO.getDebutDate(),
                artistDTO.getBiography(),
                artistDTO.getImageUrl()
        );
        return artist;
    }
}