package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.PlaylistDTO;
import com.sena.basic_crud.model.Playlist;
import com.sena.basic_crud.repository.IPlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private IPlaylist data;

    public ResponseDTO save(PlaylistDTO playlistDTO) {
        ResponseDTO res;
        List<String> errors = validate(playlistDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            Playlist playlist = convertToModel(playlistDTO);
            data.save(playlist);
            res = ResponseDTO.ok("Request made successful, new Playlist created");
        }
        return res;
    }

    public List<Playlist> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Playlist> playlist = data.findById(id);
        if (playlist.isPresent()) {
            res = ResponseDTO.ok("Playlist found", playlist.get());
        } else {
            res = ResponseDTO.error("Playlist with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(PlaylistDTO playlistDTO) {
        List<String> errors = new ArrayList<>();

        // Validar usuario
        if (playlistDTO.getUserId() == null) {
            errors.add("El usuario es obligatorio");
        }

        // Validar nombre
        if (playlistDTO.getName() == null || playlistDTO.getName().trim().isEmpty()) {
            errors.add("El nombre de la playlist es obligatorio");
        }

        return errors;
    }

    public Playlist convertToModel(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist(
                playlistDTO.getUserId(),
                playlistDTO.getName(),
                playlistDTO.getDescription(),
                playlistDTO.isPublic(),
                playlistDTO.getImageUrl()
        );
        return playlist;
    }
}