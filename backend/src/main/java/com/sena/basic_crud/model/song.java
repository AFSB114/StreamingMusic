package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "song")
public class song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private int song_id;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private album album_id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private artist artist_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "track_number")
    private int track_number;

    @Column(name = "release_date")
    private Date release_date;

    @Column(name = "composer")
    private String composer;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "file_url")
    private String file_url;

    @OneToMany(mappedBy = "song_id", cascade = CascadeType.ALL)
    private List<song_genre> song_genres;

    @OneToMany(mappedBy = "song_id", cascade = CascadeType.ALL)
    private List<playlist_song> playlist_songs;

    @OneToMany(mappedBy = "song_id", cascade = CascadeType.ALL)
    private List<playback> playbacks;

    public song() {

    }

    public song(int song_id, album album_id, artist artist_id, String title, int duration, int track_number, Date release_date, String composer, String lyrics, String file_url) {
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

    public album getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(album album_id) {
        this.album_id = album_id;
    }

    public artist getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(artist artist_id) {
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
