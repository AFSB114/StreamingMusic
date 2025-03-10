package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.PlaylistDTO;
import com.sena.basic_crud.model.Playlist;
import com.sena.basic_crud.repository.IPlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    @Autowired
    private IPlaylist data;

    public void save(PlaylistDTO playlistDTO) {
        Playlist playlist = convertToModel(playlistDTO);
        data.save(playlist);
    }

    public Playlist convertToModel(PlaylistDTO playlistDTO) {
        return new Playlist(
                playlistDTO.getId(),
                playlistDTO.getUserId(),
                playlistDTO.getName(),
                playlistDTO.getDescription(),
                playlistDTO.getCreationDate(),
                playlistDTO.isPublic(),
                playlistDTO.getImageUrl()
        );
    }

    public PlaylistDTO convertToDTO(Playlist playlist) {
        return new PlaylistDTO(
                playlist.getId(),
                playlist.getUserId(),
                playlist.getName(),
                playlist.getDescription(),
                playlist.getCreationDate(),
                playlist.isIsPublic(),
                playlist.getImageUrl()
        );
    }
}
