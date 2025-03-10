package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.PlaybackDTO;
import com.sena.basic_crud.service.PlaybackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/playback")
public class PlaybackController {
    @Autowired
    private PlaybackService playbackService;

    @PostMapping("/")
    private ResponseEntity<Object> registerPlayback(@RequestBody PlaybackDTO playback) {
        playbackService.save(playback);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
