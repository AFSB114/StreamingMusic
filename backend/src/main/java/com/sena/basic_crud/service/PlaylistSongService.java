package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.PlaylistSongDTO;
import com.sena.basic_crud.model.PlaylistSong;
import com.sena.basic_crud.repository.IPlaylistSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistSongService {
    @Autowired
    private IPlaylistSong data;

    public void save(PlaylistSongDTO playlistSongDTO) {
        PlaylistSong playlistSong = convertToModel(playlistSongDTO);
        data.save(playlistSong);
    }

    public PlaylistSong convertToModel(PlaylistSongDTO playlistSongDTO) {
        return new PlaylistSong(
                playlistSongDTO.getId(),
                playlistSongDTO.getPlaylistId(),
                playlistSongDTO.getSongId()
        );
    }

    public PlaylistSongDTO convertToDTO(PlaylistSong playlistSong) {
        return new PlaylistSongDTO(
                playlistSong.getId(),
                playlistSong.getPlaylistId(),
                playlistSong.getSongId()
        );
    }
}
