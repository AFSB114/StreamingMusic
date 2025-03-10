package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.SongGenreDTO;
import com.sena.basic_crud.service.SongGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/song-genre")
public class SongGenreController {
    @Autowired
    private SongGenreService songGenreService;

    @PostMapping("/")
    private ResponseEntity<Object> registerSongGenre(@RequestBody SongGenreDTO songGenre) {
        songGenreService.save(songGenre);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
