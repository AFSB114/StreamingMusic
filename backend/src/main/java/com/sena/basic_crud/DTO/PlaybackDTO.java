package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.Song;
import com.sena.basic_crud.model.User;

import java.sql.Timestamp;

public class PlaybackDTO {

    private int id;
    private User userId;
    private Song songId;
    private Timestamp dateTime;
    private int listenedDuration;
    private String device;
    private String location;

    public PlaybackDTO(int id, User userId, Song songId, Timestamp dateTime, int listenedDuration, String device, String location) {
        this.id = id;
        this.userId = userId;
        this.songId = songId;
        this.dateTime = dateTime;
        this.listenedDuration = listenedDuration;
        this.device = device;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Song getSongId() {
        return songId;
    }

    public void setSongId(Song songId) {
        this.songId = songId;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public int getListenedDuration() {
        return listenedDuration;
    }

    public void setListenedDuration(int listenedDuration) {
        this.listenedDuration = listenedDuration;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
