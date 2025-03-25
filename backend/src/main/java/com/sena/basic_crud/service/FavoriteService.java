package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.FavoriteDTO;
import com.sena.basic_crud.model.Favorite;
import com.sena.basic_crud.repository.IFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    @Autowired
    private IFavorite data;

    public ResponseDTO save(FavoriteDTO favoriteDTO) {
        ResponseDTO res;
        List<String> errors = validate(favoriteDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            Favorite favorite = convertToModel(favoriteDTO);
            data.save(favorite);
            res = ResponseDTO.ok("Request made successful, new Favorite added");
        }
        return res;
    }

    public List<Favorite> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Favorite> favorite = data.findById(id);
        if (favorite.isPresent()) {
            res = ResponseDTO.ok("Favorite found", favorite.get());
        } else {
            res = ResponseDTO.error("Favorite with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(FavoriteDTO favoriteDTO) {
        List<String> errors = new ArrayList<>();

        // Validar usuario
        if (favoriteDTO.getUserId() == null) {
            errors.add("El usuario es obligatorio");
        }

        // Validar tipo de objeto
        if (favoriteDTO.getObjectType() == null || favoriteDTO.getObjectType().trim().isEmpty()) {
            errors.add("El tipo de objeto es obligatorio");
        } else if (favoriteDTO.getObjectType().length() > 50) {
            errors.add("El tipo de objeto no puede exceder los 50 caracteres");
        }

        // Validar ID del objeto
        if (favoriteDTO.getObjectId() <= 0) {
            errors.add("El ID del objeto debe ser un número positivo");
        }

        return errors;
    }

    public Favorite convertToModel(FavoriteDTO favoriteDTO) {
        return new Favorite(
                favoriteDTO.getUserId(),
                favoriteDTO.getObjectType(),
                favoriteDTO.getObjectId()
        );
    }
}
