package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ArtistGenreDTO;
import com.sena.basic_crud.model.ArtistGenre;
import com.sena.basic_crud.repository.IArtistGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistGenreService {
    @Autowired
    private IArtistGenre data;

    public void save(ArtistGenreDTO artistGenreDTO) {
        ArtistGenre artistGenre = convertToModel(artistGenreDTO);
        data.save(artistGenre);
    }

    public ArtistGenre convertToModel(ArtistGenreDTO artistGenreDTO) {
        return new ArtistGenre(
                artistGenreDTO.getId(),
                artistGenreDTO.getArtistId(),
                artistGenreDTO.getGenreId()
        );
    }

    public ArtistGenreDTO convertToDTO(ArtistGenre artistGenre) {
        return new ArtistGenreDTO(
                artistGenre.getId(),
                artistGenre.getArtistId(),
                artistGenre.getGenreId()
        );
    }
}
