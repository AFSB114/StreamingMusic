package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.SongDTO;
import com.sena.basic_crud.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/song")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping("/")
    private ResponseEntity<Object> registerSong(@RequestBody SongDTO song) {
        songService.save(song);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
