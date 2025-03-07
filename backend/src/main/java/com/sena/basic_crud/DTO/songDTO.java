package com.sena.basic_crud.DTO;

import java.sql.Date;

public class songDTO {

    private int song_id;
    private int album_id;
    private int artist_id;
    private String title;
    private int duration;
    private int track_number;
    private Date release_date;
    private String composer;
    private String lyrics;
    private String file_url;

    public songDTO(int song_id, int album_id, int artist_id, String title, int duration, int track_number, Date release_date, String composer, String lyrics, String file_url) {
        this.song_id = song_id;
        this.album_id = album_id;
        this.artist_id = artist_id;
        this.title = title;
        this.duration = duration;
        this.track_number = track_number;
        this.release_date = release_date;
        this.composer = composer;
        this.lyrics = lyrics;
        this.file_url = file_url;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTrack_number() {
        return track_number;
    }

    public void setTrack_number(int track_number) {
        this.track_number = track_number;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }
}
