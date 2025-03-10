package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.PlaylistSongDTO;
import com.sena.basic_crud.service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/playlist-song")
public class PlaylistSongController {
    @Autowired
    private PlaylistSongService playlistSongService;

    @PostMapping("/")
    private ResponseEntity<Object> registerPlaylistSong(@RequestBody PlaylistSongDTO playlistSong) {
        playlistSongService.save(playlistSong);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
