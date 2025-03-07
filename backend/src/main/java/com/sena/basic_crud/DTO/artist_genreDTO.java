package com.sena.basic_crud.DTO;

public class artist_genreDTO {

    private int artist_genre_id;
    private int artist_id;
    private int genre_id;

    public artist_genreDTO(int artist_genre_id, int artist_id, int genre_id) {
        this.artist_genre_id = artist_genre_id;
        this.artist_id = artist_id;
        this.genre_id = genre_id;
    }

    public int getArtist_genre_id() {
        return artist_genre_id;
    }

    public void setArtist_genre_id(int artist_genre_id) {
        this.artist_genre_id = artist_genre_id;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
}
