package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.PlaybackDTO;
import com.sena.basic_crud.model.Playback;
import com.sena.basic_crud.service.PlaybackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/playback")
public class PlaybackController {

    private final PlaybackService playbackService;

    @Autowired
    public PlaybackController(PlaybackService playbackService) {
        this.playbackService = playbackService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addPlayback(@ModelAttribute PlaybackDTO playback) {
        ResponseDTO res = playbackService.save(playback);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllPlaybacks() {
        List<Playback> playbacks = playbackService.findAll();
        return new ResponseEntity(playbacks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPlaybackById(@PathVariable int id) {
        ResponseDTO res = playbackService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deletePlayback(@PathVariable int id) {
//        ResponseDTO res = playbackService.delete(id);
//        return new ResponseEntity(res, res.getStatus());
//    }
}