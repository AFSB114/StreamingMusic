package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.AlbumDTO;
import com.sena.basic_crud.model.Album;
import com.sena.basic_crud.repository.IAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    private IAlbum data;

    public void save(AlbumDTO albumDTO) {
        Album album = convertToModel(albumDTO);
        data.save(album);
    }

    public Album convertToModel(AlbumDTO albumDTO) {
        return new Album(
                albumDTO.getId(),
                albumDTO.getArtistId(),
                albumDTO.getRecordLabelId(),
                albumDTO.getTitle(),
                albumDTO.getReleaseDate(),
                albumDTO.getCoverUrl(),
                albumDTO.getType(),
                albumDTO.getTotalDuration(),
                albumDTO.getDescription()
        );
    }

    public AlbumDTO convertToDTO(Album album) {
        return new AlbumDTO(
                album.getId(),
                album.getArtistId(),
                album.getRecordLabelId(),
                album.getTitle(),
                album.getReleaseDate(),
                album.getCoverUrl(),
                album.getType(),
                album.getTotalDuration(),
                album.getDescription()
        );
    }
}
