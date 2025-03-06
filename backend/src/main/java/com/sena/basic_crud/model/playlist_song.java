package com.sena.basic_crud.model;

import jakarta.persistence.*;

@Entity(name = "playlist_song")
public class playlist_song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_song_id")
    private int playlist_song_id;

    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = false)
    private playlist playlist_id;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private song song_id;

    public playlist_song() {

    }

    public playlist_song(int playlist_song_id, playlist playlist_id, song song_id) {
        this.playlist_song_id = playlist_song_id;
        this.playlist_id = playlist_id;
        this.song_id = song_id;
    }

    public int getPlaylist_song_id() {
        return playlist_song_id;
    }

    public void setPlaylist_song_id(int playlist_song_id) {
        this.playlist_song_id = playlist_song_id;
    }

    public playlist getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(playlist playlist) {
        this.playlist_id = playlist;
    }

    public song getSong_id() {
        return song_id;
    }

    public void setSong_id(song song) {
        this.song_id = song;
    }
}
