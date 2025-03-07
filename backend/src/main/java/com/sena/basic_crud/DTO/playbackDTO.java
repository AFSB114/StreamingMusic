package com.sena.basic_crud.DTO;

import java.sql.Timestamp;

public class playbackDTO {

    private int playback_id;
    private int user_id;
    private int song_id;
    private Timestamp date_time;
    private int listened_duration;
    private String device;
    private String location;

    public playbackDTO(int playback_id, int user_id, int song_id, Timestamp date_time, int listened_duration, String device, String location) {
        this.playback_id = playback_id;
        this.user_id = user_id;
        this.song_id = song_id;
        this.date_time = date_time;
        this.listened_duration = listened_duration;
        this.device = device;
        this.location = location;
    }

    public int getPlayback_id() {
        return playback_id;
    }

    public void setPlayback_id(int playback_id) {
        this.playback_id = playback_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public int getListened_duration() {
        return listened_duration;
    }

    public void setListened_duration(int listened_duration) {
        this.listened_duration = listened_duration;
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
