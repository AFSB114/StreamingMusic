package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.PlaylistDTO;
import com.sena.basic_crud.model.Playlist;
import com.sena.basic_crud.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addPlaylist(@RequestBody PlaylistDTO playlist) {
        ResponseDTO res = playlistService.save(playlist);
        return new ResponseEntity<>(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllPlaylists() {
        List<Playlist> playlists = playlistService.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPlaylistById(@PathVariable int id) {
        ResponseDTO res = playlistService.findById(id);
        return new ResponseEntity<>(res, res.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable int id) {
        ResponseDTO res = playlistService.delete(id);
        return new ResponseEntity(res, res.getStatus());
    }
}