package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ArtistDTO;
import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.AlbumDTO;
import com.sena.basic_crud.model.Album;
import com.sena.basic_crud.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addAlbum(@RequestBody AlbumDTO album) {
        ResponseDTO res = albumService.save(album);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllAlbums() {
        List<Album> albums = albumService.findAll();
        return new ResponseEntity(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAlbumById(@PathVariable int id) {
        ResponseDTO res = albumService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/search")
    public ResponseEntity<Object> getAlbumByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type
    ) {
        ResponseDTO res = albumService.search(name, type);
        return new ResponseEntity(res, res.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAlbum(@PathVariable int id) {
        ResponseDTO res = albumService.delete(id);
        return new ResponseEntity(res, res.getStatus());
    }

    @PutMapping(value = "/{id}", consumes = {"application/json"})
    public ResponseEntity<Object> updateAlbum(
            @PathVariable int id,
            @RequestBody AlbumDTO album
    ) {
        ResponseDTO res = albumService.update(id, album);
        return new ResponseEntity(res, res.getStatus());
    }
}
