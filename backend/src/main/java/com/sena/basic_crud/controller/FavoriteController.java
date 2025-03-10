package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.FavoriteDTO;
import com.sena.basic_crud.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/")
    private ResponseEntity<Object> registerFavorite(@RequestBody FavoriteDTO favorite) {
        favoriteService.save(favorite);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
