package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.PlaylistDTO;
import com.sena.basic_crud.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/")
    private ResponseEntity<Object> registerPlaylist(@RequestBody PlaylistDTO playlist) {
        playlistService.save(playlist);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
