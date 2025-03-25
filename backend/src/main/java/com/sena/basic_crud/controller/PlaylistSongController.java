package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.PlaylistSongDTO;
import com.sena.basic_crud.model.PlaylistSong;
import com.sena.basic_crud.service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/playlist-song")
public class PlaylistSongController {

    private final PlaylistSongService playlistSongService;

    @Autowired
    public PlaylistSongController(PlaylistSongService playlistSongService) {
        this.playlistSongService = playlistSongService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addPlaylistSong(@ModelAttribute PlaylistSongDTO playlistSong) {
        ResponseDTO res = playlistSongService.save(playlistSong);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllPlaylistSongs() {
        List<PlaylistSong> playlistSongs = playlistSongService.findAll();
        return new ResponseEntity(playlistSongs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPlaylistSongById(@PathVariable int id) {
        ResponseDTO res = playlistSongService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deletePlaylistSong(@PathVariable int id) {
//        ResponseDTO res = playlistSongService.delete(id);
//        return new ResponseEntity(res, res.getStatus());
//    }
}