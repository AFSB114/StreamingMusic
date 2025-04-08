package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SongDTO;
import com.sena.basic_crud.model.Song;
import com.sena.basic_crud.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/song")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addSong(@RequestBody SongDTO song) {
        ResponseDTO res = songService.save(song);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllSongs() {
        List<Song> songs = songService.findAll();
        return new ResponseEntity(songs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSongById(@PathVariable int id) {
        ResponseDTO res = songService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteSong(@PathVariable int id) {
//        ResponseDTO res = songService.delete(id);
//        return new ResponseEntity(res, res.getStatus());
//    }
}
