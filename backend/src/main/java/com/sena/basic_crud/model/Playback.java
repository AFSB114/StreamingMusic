package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity(name = "playback")
public class Playback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song songId;

    @Column(name = "date_time", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp dateTime;

    @Column(name = "listened_duration")
    private int listenedDuration;

    @Column(name = "device", length = 100)
    private String device;

    @Column(name = "location")
    private String location;

    public Playback(){

    }

    public Playback(int id, User userId, Song songId, Timestamp dateTime, int listenedDuration, String device, String location) {
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

    public void setId(int playback_id) {
        this.id = playback_id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user_id) {
        this.userId = user_id;
    }

    public Song getSongId() {
        return songId;
    }

    public void setSongId(Song song_id) {
        this.songId = song_id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp date_time) {
        this.dateTime = date_time;
    }

    public int getListenedDuration() {
        return listenedDuration;
    }

    public void setListenedDuration(int listened_duration) {
        this.listenedDuration = listened_duration;
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
