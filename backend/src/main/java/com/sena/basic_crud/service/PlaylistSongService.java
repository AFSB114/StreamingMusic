package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.PlaylistSongDTO;
import com.sena.basic_crud.model.PlaylistSong;
import com.sena.basic_crud.repository.IPlaylist;
import com.sena.basic_crud.repository.IPlaylistSong;
import com.sena.basic_crud.repository.ISong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistSongService {
    @Autowired
    private IPlaylistSong data;

    @Autowired
    private IPlaylist  playlist;

    @Autowired
    private ISong song;

    public ResponseDTO save(PlaylistSongDTO playlistSongDTO) {
        ResponseDTO res;
        List<String> errors = validate(playlistSongDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            PlaylistSong playlistSong = convertToModel(playlistSongDTO);
            data.save(playlistSong);
            res = ResponseDTO.ok("Request made successful, new PlaylistSong created");
        }
        return res;
    }

    public List<PlaylistSong> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<PlaylistSong> playlistSong = data.findById(id);
        if (playlistSong.isPresent()) {
            res = ResponseDTO.ok("PlaylistSong found", playlistSong.get());
        } else {
            res = ResponseDTO.error("PlaylistSong with id: " + id + " not found");
        }
        return res;
    }

    public ResponseDTO delete(int id) {
        ResponseDTO res;
        Optional<PlaylistSong> playlistSong = data.findById(id);
        if (playlistSong.isPresent()) {
            data.delete(playlistSong.get());
            res = ResponseDTO.ok("PlaylistSong deleted");
        } else  {
            res = ResponseDTO.error("PlaylistSong with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(PlaylistSongDTO playlistSongDTO) {
        List<String> errors = new ArrayList<>();
        boolean emptySong = song.findById(playlistSongDTO.getSongId().getId()).isEmpty();
        boolean emptyPlaylist = playlist.findById(playlistSongDTO.getPlaylistId().getId()).isEmpty();


        // Validar playlist
        if (playlistSongDTO.getPlaylistId() == null) {
            errors.add("La playlist es obligatoria");
        } else if (emptySong) {
            errors.add("La canción no existe");
        }

        // Validar canción
        if (playlistSongDTO.getSongId() == null) {
            errors.add("La canción es obligatoria");
        } else if (emptyPlaylist) {
            errors.add("La playlist no existe");
        }

        return errors;
    }

    public PlaylistSong convertToModel(PlaylistSongDTO playlistSongDTO) {
        PlaylistSong playlistSong = new PlaylistSong(
                playlistSongDTO.getPlaylistId(),
                playlistSongDTO.getSongId()
        );
        return playlistSong;
    }
}
