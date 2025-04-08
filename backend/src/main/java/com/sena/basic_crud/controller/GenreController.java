package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.GenreDTO;
import com.sena.basic_crud.model.Genre;
import com.sena.basic_crud.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addGenre(@RequestBody GenreDTO genre) {
        ResponseDTO res = genreService.save(genre);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllGenres() {
        List<Genre> genres = genreService.findAll();
        return new ResponseEntity(genres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGenreById(@PathVariable int id) {
        ResponseDTO res = genreService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/search")
    public ResponseEntity<Object> getGenreByFilters(
            @RequestParam(required = false) String name
    ) {
        ResponseDTO res = genreService.search(name);
        return new ResponseEntity(res, res.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGenre(@PathVariable int id) {
        ResponseDTO res = genreService.delete(id);
        return new ResponseEntity(res, res.getStatus());
    }

    @PutMapping(value = "/{id}", consumes = {"application/json"})
    public ResponseEntity<Object> updateGenre(
            @PathVariable int id,
            @RequestBody GenreDTO genre
    ) {
        ResponseDTO res = genreService.update(id, genre);
        return new ResponseEntity(res, res.getStatus());
    }
}
