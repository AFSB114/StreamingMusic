package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.GenreDTO;
import com.sena.basic_crud.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @PostMapping("/")
    private ResponseEntity<Object> registerGenre(@RequestBody GenreDTO genre) {
        genreService.save(genre);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
