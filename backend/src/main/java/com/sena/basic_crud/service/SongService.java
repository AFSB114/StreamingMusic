package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.SongDTO;
import com.sena.basic_crud.model.Song;
import com.sena.basic_crud.repository.ISong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    @Autowired
    private ISong data;

    public void save(SongDTO songDTO) {
        Song song = convertToModel(songDTO);
        data.save(song);
    }

    public Song convertToModel(SongDTO songDTO) {
        return new Song(
                songDTO.getId(),
                songDTO.getAlbumId(),
                songDTO.getArtistId(),
                songDTO.getTitle(),
                songDTO.getDuration(),
                songDTO.getTrackNumber(),
                songDTO.getReleaseDate(),
                songDTO.getComposer(),
                songDTO.getLyrics(),
                songDTO.getFileUrl(),
                songDTO.getImageUrl()
        );
    }

    public SongDTO convertToDTO(Song song) {
        return new SongDTO(
                song.getId(),
                song.getAlbumId(),
                song.getArtistId(),
                song.getTitle(),
                song.getDuration(),
                song.getTrackNumber(),
                song.getReleaseDate(),
                song.getComposer(),
                song.getLyrics(),
                song.getFileUrl(),
                song.getImageUrl()
        );
    }
}
