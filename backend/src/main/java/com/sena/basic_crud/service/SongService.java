package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SongDTO;
import com.sena.basic_crud.model.Album;
import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.model.Genre;
import com.sena.basic_crud.model.Song;
import com.sena.basic_crud.repository.IAlbum;
import com.sena.basic_crud.repository.IArtist;
import com.sena.basic_crud.repository.IGenre;
import com.sena.basic_crud.repository.ISong;
import com.sena.basic_crud.specification.SongSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final ISong data;
    private final IAlbum album;

    @Autowired
    public SongService(ISong data, IAlbum album) {
        this.data = data;
        this.album = album;
    }

    public ResponseDTO save(SongDTO songDTO) {
        List<String> errors = validate(songDTO);
        if (!errors.isEmpty()) return ResponseDTO.error("Request made wrong", errors);
        Song song = convertToModel(songDTO);
        data.save(song);
        if (songDTO.getAlbumId() != null) {
            Optional<Album> optionalAlbum = album.findById(song.getAlbumId().getId());
            if (optionalAlbum.isPresent()) {
                Album currentAlbum = optionalAlbum.get();
                currentAlbum.setTotalDuration(songDTO.getDuration() + currentAlbum.getTotalDuration());
            }
        }
        return ResponseDTO.ok("Request made successful, new Song created", song);
    }

    public List<Song> findAll() {
        return data.findAll();
    }

    public ResponseDTO search(String title, Integer genreId){
        Specification<Song> spec = Specification.where(SongSpecification.hasName(title)).and(SongSpecification.hasGenreId(genreId));
        List<Song> songs = data.findAll(spec);
        return ResponseDTO.ok("Request made successful, songs found", songs);
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Song> song = data.findById(id);
        res = song.map(value -> ResponseDTO.ok("Song found", value)).orElseGet(() -> ResponseDTO.error("Song with id: " + id + " not found"));
        return res;
    }

    public ResponseDTO delete(int id) {
        Optional<Song> song = data.findById(id);
        if (!song.isPresent()) return ResponseDTO.error("Song with id: " + id + " not found");
        data.deleteById(id);
        return ResponseDTO.ok("Song deleted");
    }

    public ResponseDTO update(int id, SongDTO songDTO) {
        Optional<Song> optionalSong = data.findById(id);

        if (!optionalSong.isPresent())
            return ResponseDTO.error("Song with id: " + id + " not found");

        Song currentSong = optionalSong.get();

        currentSong.setAlbumId(songDTO.getAlbumId() != null ? songDTO.getAlbumId() : currentSong.getAlbumId());
        currentSong.setArtistId(songDTO.getArtistId() != null ? songDTO.getArtistId() : currentSong.getArtistId());
        currentSong.setGenreId(songDTO.getGenreId() != null ? songDTO.getGenreId() : currentSong.getGenreId());
        currentSong.setTitle(songDTO.getTitle() != null ? songDTO.getTitle() : currentSong.getTitle());
        currentSong.setDuration(songDTO.getDuration() != 0 ? songDTO.getDuration() : currentSong.getDuration());
        currentSong.setReleaseDate(songDTO.getReleaseDate() != null ? songDTO.getReleaseDate() : currentSong.getReleaseDate());
        currentSong.setComposer(songDTO.getComposer() != null ? songDTO.getComposer() : currentSong.getComposer());
        currentSong.setLyrics(songDTO.getLyrics() != null ? songDTO.getLyrics() : currentSong.getLyrics());
        currentSong.setFileUrl(songDTO.getFileUrl() != null ? songDTO.getFileUrl() : currentSong.getFileUrl());
        currentSong.setImageUrl(songDTO.getImageUrl() != null ? songDTO.getImageUrl() : currentSong.getImageUrl());

        data.save(currentSong);

        return ResponseDTO.ok("Song updated", currentSong);
    }


    public List<String> validate(SongDTO songDTO) {
        List<String> errors = new ArrayList<>();

        // Validar artista
        if (songDTO.getArtistId() == null) {
            errors.add("El artista es obligatorio");
        }

        // Validar título
        if (songDTO.getTitle() == null || songDTO.getTitle().trim().isEmpty()) {
            errors.add("El título es obligatorio");
        }

        // Validar duración
        if (songDTO.getDuration() <= 0) {
            errors.add("La duración debe ser mayor a 0");
        }

        // Validar URL del archivo
        if (songDTO.getFileUrl() != null && songDTO.getFileUrl().length() > 255) {
            errors.add("La URL del archivo no puede exceder los 255 caracteres");
        }

        // Validar URL de imagen
        if (songDTO.getImageUrl() != null && songDTO.getImageUrl().length() > 255) {
            errors.add("La URL de la imagen no puede exceder los 255 caracteres");
        }

        return errors;
    }

    public Song convertToModel(SongDTO songDTO) {
        Song song = new Song(
                songDTO.getGenreId(),
                songDTO.getAlbumId(),
                songDTO.getArtistId(),
                songDTO.getTitle(),
                songDTO.getDuration(),
                songDTO.getReleaseDate(),
                songDTO.getComposer(),
                songDTO.getLyrics(),
                songDTO.getFileUrl(),
                songDTO.getImageUrl()
        );
        return song;
    }
}
