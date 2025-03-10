package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ArtistGenreDTO;
import com.sena.basic_crud.service.ArtistGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artist-genre")
public class ArtistGenreController {
    @Autowired
    private ArtistGenreService artistGenreService;

    @PostMapping("/")
    private ResponseEntity<Object> registerArtistGenre(@RequestBody ArtistGenreDTO artistGenre) {
        artistGenreService.save(artistGenre);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
