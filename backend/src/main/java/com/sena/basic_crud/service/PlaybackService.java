package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.PlaybackDTO;
import com.sena.basic_crud.model.Playback;
import com.sena.basic_crud.repository.IPlayback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaybackService {
    @Autowired
    private IPlayback data;

    public void save(PlaybackDTO playbackDTO) {
        Playback playback = convertToModel(playbackDTO);
        data.save(playback);
    }

    public Playback convertToModel(PlaybackDTO playbackDTO) {
        return new Playback(
                playbackDTO.getId(),
                playbackDTO.getUserId(),
                playbackDTO.getSongId(),
                playbackDTO.getDateTime(),
                playbackDTO.getListenedDuration(),
                playbackDTO.getDevice(),
                playbackDTO.getLocation()
        );
    }

    public PlaybackDTO convertToDTO(Playback playback) {
        return new PlaybackDTO(
                playback.getId(),
                playback.getUserId(),
                playback.getSongId(),
                playback.getDateTime(),
                playback.getListenedDuration(),
                playback.getDevice(),
                playback.getLocation()
        );
    }
}
