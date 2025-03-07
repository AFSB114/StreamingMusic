package com.sena.basic_crud.DTO;

import java.sql.Timestamp;

public class PlaybackDTO {

    private int id;
    private int userId;
    private int songId;
    private Timestamp dateTime;
    private int listenedDuration;
    private String device;
    private String location;

    public PlaybackDTO(int id, int userId, int songId, Timestamp dateTime, int listenedDuration, String device, String location) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
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
