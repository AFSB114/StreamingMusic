package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SongDTO;
import com.sena.basic_crud.model.Song;
import com.sena.basic_crud.repository.ISong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private ISong data;

    public ResponseDTO save(SongDTO songDTO) {
        ResponseDTO res;
        List<String> errors = validate(songDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            Song song = convertToModel(songDTO);
            data.save(song);
            res = ResponseDTO.ok("Request made successful, new Song created");
        }
        return res;
    }

    public List<Song> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Song> song = data.findById(id);
        if (song.isPresent()) {
            res = ResponseDTO.ok("Song found", song.get());
        } else {
            res = ResponseDTO.error("Song with id: " + id + " not found");
        }
        return res;
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

        // Validar número de pista (opcional, pero no puede ser negativo)
        if (songDTO.getTrackNumber() < 0) {
            errors.add("El número de pista no puede ser negativo");
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
                songDTO.getAlbumId(),
                songDTO.getArtistId(),
                songDTO.getTitle(),
                songDTO.getDuration(),
                songDTO.getTrackNumber(),
                songDTO.getReleaseDate(),
                songDTO.getComposer(),
                songDTO.getLyrics(),
                songDTO.getFileUrl(),
                songDTO.getImageUrl()
        );
        return song;
    }
}
