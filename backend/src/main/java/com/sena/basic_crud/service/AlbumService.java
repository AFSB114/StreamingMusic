package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.AlbumDTO;
import com.sena.basic_crud.model.Album;
import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.model.RecordLabel;
import com.sena.basic_crud.repository.IAlbum;
import com.sena.basic_crud.repository.IArtist;
import com.sena.basic_crud.repository.IRecordLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private IAlbum data;

    @Autowired
    private IArtist artistRepository;

    @Autowired
    private IRecordLabel recordLabelRepository;

    public ResponseDTO save(AlbumDTO albumDTO) {
        ResponseDTO res;
        List<String> errors = validate(albumDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            Album album = convertToModel(albumDTO);
            data.save(album);
            res = ResponseDTO.ok("Request made successful, new Album created");
        }
        return res;
    }

    public List<Album> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Album> album = data.findById(id);
        if (album.isPresent()) {
            res = ResponseDTO.ok("Album found", album.get());
        } else {
            res = ResponseDTO.error("Album with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(AlbumDTO albumDTO) {
        List<String> errors = new ArrayList<>();

        if (albumDTO.getTitle() == null || albumDTO.getTitle().trim().isEmpty()) {
            errors.add("El título del álbum es obligatorio");
        }

        if (albumDTO.getReleaseDate() == null) {
            errors.add("La fecha de lanzamiento es obligatoria");
        }

        if (albumDTO.getArtistId() == null || !artistRepository.existsById(albumDTO.getArtistId().getId())) {
            errors.add("El artista con ID " + albumDTO.getArtistId() + " no existe");
        }

        if (albumDTO.getRecordLabelId() == null || !recordLabelRepository.existsById(albumDTO.getRecordLabelId().getId())) {
            errors.add("El sello discográfico con ID " + albumDTO.getRecordLabelId() + " no existe");
        }

        return errors;
    }

    public Album convertToModel(AlbumDTO albumDTO) {
        Artist artist = artistRepository.findById(albumDTO.getArtistId().getId()).orElse(null);
        RecordLabel recordLabel = recordLabelRepository.findById(albumDTO.getRecordLabelId().getId()).orElse(null);

        return new Album(
                artist,
                recordLabel,
                albumDTO.getTitle(),
                albumDTO.getReleaseDate(),
                albumDTO.getCoverUrl(),
                albumDTO.getType(),
                albumDTO.getTotalDuration(),
                albumDTO.getDescription()
        );
    }
}
