package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.Playlist;
import com.sena.basic_crud.model.Song;

public class PlaylistSongDTO {

    private int id;
    private Playlist playlistId;
    private Song songId;

    public PlaylistSongDTO(Playlist playlistId, Song songId) {
        this.playlistId = playlistId;
        this.songId = songId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Playlist getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Playlist playlistId) {
        this.playlistId = playlistId;
    }

    public Song getSongId() {
        return songId;
    }

    public void setSongId(Song songId) {
        this.songId = songId;
    }
}
