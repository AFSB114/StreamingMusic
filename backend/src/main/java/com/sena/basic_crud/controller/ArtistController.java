package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.ArtistDTO;
import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping(value = "/", consumes = {"application/json"})
    public ResponseEntity<Object> addArtist(@RequestBody ArtistDTO artist) {
        ResponseDTO res = artistService.save(artist);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllArtists() {
        List<Artist> artists = artistService.findAll();
        return new ResponseEntity(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getArtistById(@PathVariable int id) {
        ResponseDTO res = artistService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/search")
    public ResponseEntity<Object> getArtistByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type
    ) {
        ResponseDTO res = artistService.search(name, type);
        return new ResponseEntity(res, res.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArtist(@PathVariable int id) {
        ResponseDTO res = artistService.delete(id);
        return new ResponseEntity(res, res.getStatus());
    }

    @PutMapping(value = "/{id}", consumes = {"application/json"})
    public ResponseEntity<Object> updateArtist(
            @PathVariable int id,
            @RequestBody ArtistDTO artist
    ) {
        ResponseDTO res = artistService.update(id, artist);
        return new ResponseEntity(res, res.getStatus());
    }
}
