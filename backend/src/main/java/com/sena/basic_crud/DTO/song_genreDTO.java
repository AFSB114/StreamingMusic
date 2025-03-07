package com.sena.basic_crud.DTO;

public class song_genreDTO {

    private int song_genre_id;
    private int song_id;
    private int genre_id;

    public song_genreDTO(int song_genre_id, int song_id, int genre_id) {
        this.song_genre_id = song_genre_id;
        this.song_id = song_id;
        this.genre_id = genre_id;
    }

    public int getSong_genre_id() {
        return song_genre_id;
    }

    public void setSong_genre_id(int song_genre_id) {
        this.song_genre_id = song_genre_id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
}
