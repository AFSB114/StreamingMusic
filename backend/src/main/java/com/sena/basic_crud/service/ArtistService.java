package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ArtistDTO;
import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.repository.IArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private IArtist data;

    public void save(ArtistDTO artistDTO) {
        Artist artist = convertToModel(artistDTO);
        data.save(artist);
    }

    public Artist convertToModel(ArtistDTO artistDTO) {
        return new Artist(
                artistDTO.getId(),
                artistDTO.getName(),
                artistDTO.getType(),
                artistDTO.getCountryOfOrigin(),
                artistDTO.getDebutDate(),
                artistDTO.getBiography(),
                artistDTO.getImageUrl()
        );
    }

    public ArtistDTO convertToDTO(Artist artist) {
        return new ArtistDTO(
                artist.getId(),
                artist.getName(),
                artist.getType(),
                artist.getCountryOfOrigin(),
                artist.getDebutDate(),
                artist.getBiography(),
                artist.getImageUrl()
        );
    }
}
