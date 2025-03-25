package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SongGenreDTO;
import com.sena.basic_crud.model.SongGenre;
import com.sena.basic_crud.service.SongGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/song-genre")
public class SongGenreController {

    private final SongGenreService songGenreService;

    @Autowired
    public SongGenreController(SongGenreService songGenreService) {
        this.songGenreService = songGenreService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addSongGenre(@ModelAttribute SongGenreDTO songGenre) {
        ResponseDTO res = songGenreService.save(songGenre);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllSongGenres() {
        List<SongGenre> songGenres = songGenreService.findAll();
        return new ResponseEntity(songGenres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSongGenreById(@PathVariable int id) {
        ResponseDTO res = songGenreService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteSongGenre(@PathVariable int id) {
//        ResponseDTO res = songGenreService.delete(id);
//        return new ResponseEntity(res, res.getStatus());
//    }
}
