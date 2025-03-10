package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.FavoriteDTO;
import com.sena.basic_crud.model.Favorite;
import com.sena.basic_crud.repository.IFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    @Autowired
    private IFavorite data;

    public void save(FavoriteDTO favoriteDTO) {
        Favorite favorite = convertToModel(favoriteDTO);
        data.save(favorite);
    }

    public Favorite convertToModel(FavoriteDTO favoriteDTO) {
        return new Favorite(
                favoriteDTO.getId(),
                favoriteDTO.getUserId(),
                favoriteDTO.getObjectType(),
                favoriteDTO.getObjectId(),
                favoriteDTO.getDateMarked()
        );
    }

    public FavoriteDTO convertToDTO(Favorite favorite) {
        return new FavoriteDTO(
                favorite.getId(),
                favorite.getUserId(),
                favorite.getObjectType(),
                favorite.getObjectId(),
                favorite.getDateMarked()
        );
    }
}
