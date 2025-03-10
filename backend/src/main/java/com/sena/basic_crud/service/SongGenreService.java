package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.SongGenreDTO;
import com.sena.basic_crud.model.SongGenre;
import com.sena.basic_crud.repository.ISongGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongGenreService {
    @Autowired
    private ISongGenre data;

    public void save(SongGenreDTO songGenreDTO) {
        SongGenre songGenre = convertToModel(songGenreDTO);
        data.save(songGenre);
    }

    public SongGenre convertToModel(SongGenreDTO songGenreDTO) {
        return new SongGenre(
                songGenreDTO.getId(),
                songGenreDTO.getSongId(),
                songGenreDTO.getGenreId()
        );
    }

    public SongGenreDTO convertToDTO(SongGenre songGenre) {
        return new SongGenreDTO(
                songGenre.getId(),
                songGenre.getSongId(),
                songGenre.getGenreId()
        );
    }
}
