package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.ArtistGenreDTO;
import com.sena.basic_crud.model.ArtistGenre;
import com.sena.basic_crud.service.ArtistGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artist-genre")
public class ArtistGenreController {

    private final ArtistGenreService artistGenreService;

    @Autowired
    public ArtistGenreController(ArtistGenreService artistGenreService) {
        this.artistGenreService = artistGenreService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addArtistGenre(@ModelAttribute ArtistGenreDTO artistGenre) {
        ResponseDTO res = artistGenreService.save(artistGenre);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllArtistGenres() {
        List<ArtistGenre> artistGenres = artistGenreService.findAll();
        return new ResponseEntity(artistGenres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getArtistGenreById(@PathVariable int id) {
        ResponseDTO res = artistGenreService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteArtistGenre(@PathVariable int id) {
//        ResponseDTO res = artistGenreService.delete(id);
//        return new ResponseEntity(res, res.getStatus());
//    }
}