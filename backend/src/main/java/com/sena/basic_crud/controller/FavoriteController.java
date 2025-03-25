package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.FavoriteDTO;
import com.sena.basic_crud.model.Favorite;
import com.sena.basic_crud.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addFavorite(@ModelAttribute FavoriteDTO favorite) {
        ResponseDTO res = favoriteService.save(favorite);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllFavorites() {
        List<Favorite> favorites = favoriteService.findAll();
        return new ResponseEntity(favorites, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFavoriteById(@PathVariable int id) {
        ResponseDTO res = favoriteService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteFavorite(@PathVariable int id) {
//        ResponseDTO res = favoriteService.delete(id);
//        return new ResponseEntity(res, res.getStatus());
//    }
}
