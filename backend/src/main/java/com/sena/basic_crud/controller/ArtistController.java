package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ArtistDTO;
import com.sena.basic_crud.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artist")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @PostMapping("/")
    private ResponseEntity<Object> registerArtist(@RequestBody ArtistDTO artist) {
        artistService.save(artist);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
