package com.sena.basic_crud.DTO;

public class playlist_songDTO {

    private int playlist_song_id;
    private int playlist_id;
    private int song_id;

    public playlist_songDTO(int playlist_song_id, int playlist_id, int song_id) {
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

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }
}
