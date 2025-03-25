package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.PlaybackDTO;
import com.sena.basic_crud.model.Playback;
import com.sena.basic_crud.repository.IPlayback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaybackService {
    @Autowired
    private IPlayback data;

    public ResponseDTO save(PlaybackDTO playbackDTO) {
        ResponseDTO res;
        List<String> errors = validate(playbackDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            Playback playback = convertToModel(playbackDTO);
            data.save(playback);
            res = ResponseDTO.ok("Request made successful, new Playback created");
        }
        return res;
    }

    public List<Playback> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Playback> playback = data.findById(id);
        if (playback.isPresent()) {
            res = ResponseDTO.ok("Playback found", playback.get());
        } else {
            res = ResponseDTO.error("Playback with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(PlaybackDTO playbackDTO) {
        List<String> errors = new ArrayList<>();

        // Validar usuario
        if (playbackDTO.getUserId() == null) {
            errors.add("El usuario es obligatorio");
        }

        // Validar canción
        if (playbackDTO.getSongId() == null) {
            errors.add("La canción es obligatoria");
        }

        // Validar duración escuchada
        if (playbackDTO.getListenedDuration() < 0) {
            errors.add("La duración escuchada no puede ser negativa");
        }

        return errors;
    }

    public Playback convertToModel(PlaybackDTO playbackDTO) {
        Playback playback = new Playback(
                playbackDTO.getUserId(),
                playbackDTO.getSongId(),
                playbackDTO.getListenedDuration(),
                playbackDTO.getDevice(),
                playbackDTO.getLocation()
        );
        return playback;
    }
}
