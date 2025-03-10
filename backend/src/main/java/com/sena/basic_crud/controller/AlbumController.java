package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.AlbumDTO;
import com.sena.basic_crud.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @PostMapping("/")
    private ResponseEntity<Object> registerAlbum(@RequestBody AlbumDTO album) {
        albumService.save(album);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
