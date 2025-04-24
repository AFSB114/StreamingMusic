package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.AlbumDTO;
import com.sena.basic_crud.model.Album;
import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.model.RecordLabel;
import com.sena.basic_crud.repository.IAlbum;
import com.sena.basic_crud.repository.IArtist;
import com.sena.basic_crud.repository.IRecordLabel;
import com.sena.basic_crud.specification.AlbumSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final IAlbum data;
    private final IArtist artistRepository;
    private final IRecordLabel recordLabelRepository;

    @Autowired
    public AlbumService(IAlbum data, IArtist artist, IRecordLabel recordLabelRepository) {
        this.data = data;
        this.artistRepository = artist;
        this.recordLabelRepository = recordLabelRepository;
    }

    public ResponseDTO save(AlbumDTO albumDTO) {
        ResponseDTO res;
        List<String> errors = validate(albumDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            Album album = convertToModel(albumDTO);
            data.save(album);
            res = ResponseDTO.ok("Request made successful, new Album created", album);
        }
        return res;
    }

    public List<Album> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Album> album = data.findById(id);
        res = album.map(value -> ResponseDTO.ok("Album found", value)).orElseGet(() -> ResponseDTO.error("Album with id: " + id + " not found"));
        return res;
    }

    public ResponseDTO search(String name, String type){
        Specification<Album> spec = Specification.where(AlbumSpecification.hasName(name)).and(AlbumSpecification.hasType(type));
        List<Album> Albums = data.findAll(spec);
        return ResponseDTO.ok("Albums found", Albums);
    }

    public ResponseDTO update(int id,AlbumDTO albumDTO) {
        Optional<Album> optionalAlbum = data.findById(id);

        if (optionalAlbum.isEmpty()) return ResponseDTO.error("Album with id: " + id + " not found");

        Album currentAlbum = optionalAlbum.get();
        currentAlbum.setArtistId(albumDTO.getArtistId() != null ? albumDTO.getArtistId() : currentAlbum.getArtistId());
        currentAlbum.setRecordLabelId(albumDTO.getRecordLabelId() != null ? albumDTO.getRecordLabelId() : currentAlbum.getRecordLabelId());
        currentAlbum.setTitle(albumDTO.getTitle() != null ? albumDTO.getTitle() : currentAlbum.getTitle());
        currentAlbum.setReleaseDate(albumDTO.getReleaseDate() != null ? albumDTO.getReleaseDate() : currentAlbum.getReleaseDate());
        currentAlbum.setCoverUrl(albumDTO.getCoverUrl() != null ? albumDTO.getCoverUrl() : currentAlbum.getCoverUrl());
        currentAlbum.setType(albumDTO.getType() != null ? albumDTO.getType() : currentAlbum.getType());
        currentAlbum.setDescription(albumDTO.getDescription() != null ? albumDTO.getDescription() : currentAlbum.getDescription());

        data.save(currentAlbum);

        return ResponseDTO.ok("Album updated", currentAlbum);
    }

    public ResponseDTO delete(int id) {
        Optional<Album> album = data.findById(id);
        if (album.isEmpty()) return ResponseDTO.error("Album with id: " + id + " not found");
        data.delete(album.get());
        return ResponseDTO.ok("Album deleted");
    }

    public List<String> validate(AlbumDTO albumDTO) {
        List<String> errors = new ArrayList<>();

        if (albumDTO.getTitle() == null || albumDTO.getTitle().trim().isEmpty()) {
            errors.add("The album title is required " + albumDTO.getTitle());
        }

        if (albumDTO.getReleaseDate() == null) {
            errors.add("The release date is mandatory " + albumDTO.getReleaseDate());
        }

        if (albumDTO.getArtistId() == null || !artistRepository.existsById(albumDTO.getArtistId().getId())) {
            errors.add("The artist with ID " + albumDTO.getArtistId().getId() + " does not exist");
        }

        if (albumDTO.getRecordLabelId() == null || !recordLabelRepository.existsById(albumDTO.getRecordLabelId().getId())) {
            errors.add("The record label with ID " + albumDTO.getRecordLabelId().getId() + " does not exist");
        }

        return errors;
    }

    public Album convertToModel(AlbumDTO albumDTO) {
        Optional<Artist> artist = artistRepository.findById(albumDTO.getArtistId().getId());
        Optional<RecordLabel> recordLabel = recordLabelRepository.findById(albumDTO.getRecordLabelId().getId());

        return new Album(
                artist.get(),
                recordLabel.get(),
                albumDTO.getTitle(),
                albumDTO.getReleaseDate(),
                albumDTO.getCoverUrl(),
                albumDTO.getType(),
                albumDTO.getDescription()
        );
    }
}
