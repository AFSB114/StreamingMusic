package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ArtistDTO;
import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.repository.IArtist;
import com.sena.basic_crud.specification.ArtistSpecifiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final IArtist data;

    @Autowired
    public ArtistService(IArtist data) {
        this.data = data;
    }

    public ResponseDTO save(ArtistDTO artistDTO) {
        ResponseDTO res;
        Artist artist = convertToModel(artistDTO);
        List<String> errors = validate(artist);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            artist = data.save(artist);
            res = ResponseDTO.ok("Request made successful, new Artist created", artist);
        }
        return res;
    }

    public List<Artist> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Artist> artist = data.findById(id);
        res = artist.map(value -> ResponseDTO.ok("Artist found", value)).orElseGet(() -> ResponseDTO.error("Artist with id: " + id + " not found"));
        return res;
    }

    public ResponseDTO search(String name, String type) {
        Specification<Artist> spec = Specification.where(ArtistSpecifiction.hasName(name)).and(ArtistSpecifiction.hasType(type));
        List<Artist> Artists = data.findAll(spec);

        return ResponseDTO.ok("Artists found", Artists);
    }

    public ResponseDTO update(int id, ArtistDTO artistDTO) {
        Optional<Artist> optionalArtist = data.findById(id);

        if (optionalArtist.isEmpty()) return ResponseDTO.error("Artist with id: " + id + " not found");

        Artist currentArtist = optionalArtist.get();

        currentArtist.setName((artistDTO.getName() != null) ? artistDTO.getName() : currentArtist.getName());
        currentArtist.setType((artistDTO.getType() != null) ? artistDTO.getType() : currentArtist.getType());
        currentArtist.setCountryOfOrigin((artistDTO.getCountryOfOrigin() != null) ? artistDTO.getCountryOfOrigin() : currentArtist.getCountryOfOrigin());
        currentArtist.setDebutDate((artistDTO.getDebutDate() != null) ? artistDTO.getDebutDate() : currentArtist.getDebutDate());
        currentArtist.setBiography((artistDTO.getBiography() != null) ? artistDTO.getBiography() : currentArtist.getBiography());
        currentArtist.setImageUrl((artistDTO.getImageUrl()) != null ? artistDTO.getImageUrl() : currentArtist.getImageUrl());

        data.save(currentArtist);

        return ResponseDTO.ok("Update successfully", currentArtist);
    }

    public  ResponseDTO delete(int id) {
        Optional<Artist> optionalArtist = data.findById(id);
        if (optionalArtist.isEmpty()) return ResponseDTO.error("Artist with id: " + id + " not found");
        data.deleteById(id);
        return ResponseDTO.ok("Delete successfully");
    }

    public List<String> validate(Artist artist) {
        List<String> errors = new ArrayList<>();

        if (artist.getName() == null || artist.getName().trim().isEmpty()) {
            errors.add("The artist's name is required.");
        }

        if (artist.getImageUrl() == null || artist.getImageUrl().trim().isEmpty()) {
            errors.add("The artist's image URL is required.");
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