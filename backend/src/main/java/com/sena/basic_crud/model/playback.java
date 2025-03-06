package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity(name = "playback")
public class playback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playback_id")
    private int playback_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user_id;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private song song_id;

    @Column(name = "date_time", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp date_time;

    @Column(name = "listened_duration")
    private int listened_duration;

    @Column(name = "device", length = 100)
    private String device;

    @Column(name = "location")
    private String location;

    public playback(){

    }

    public playback(int playback_id, user user_id, song song_id, Timestamp date_time, int listened_duration, String device, String location) {
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

    public user getUser_id() {
        return user_id;
    }

    public void setUser_id(user user_id) {
        this.user_id = user_id;
    }

    public song getSong_id() {
        return song_id;
    }

    public void setSong_id(song song_id) {
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
