package com.sena.basic_crud.model;

import jakarta.persistence.*;

@Entity(name = "playlist_song")
public class PlaylistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlistId;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song songId;

    public PlaylistSong() {

    }

    public PlaylistSong(int id, Playlist playlistId, Song songId) {
        this.id = id;
        this.playlistId = playlistId;
        this.songId = songId;
    }

    public int getId() {
        return id;
    }

    public void setId(int playlist_song_id) {
        this.id = playlist_song_id;
    }

    public Playlist getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Playlist playlist) {
        this.playlistId = playlist;
    }

    public Song getSongId() {
        return songId;
    }

    public void setSongId(Song song) {
        this.songId = song;
    }
}
