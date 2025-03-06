package com.sena.basic_crud.model;

import jakarta.persistence.*;

@Entity(name = "artist_genre")
public class artist_genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_genre_id")
    private int artist_genre_id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false )
    private artist artist_id;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private genre genre_id;

    public artist_genre() {

    }

    public artist_genre(int artist_genre_id, artist artist_id, genre genre_id) {
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

    public artist getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(artist artist_id) {
        this.artist_id = artist_id;
    }

    public genre getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(genre genre_id) {
        this.genre_id = genre_id;
    }
}
