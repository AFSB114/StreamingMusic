package com.sena.basic_crud.model;

import jakarta.persistence.*;

@Entity(name = "song_genre")
public class song_genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_genre_id")
    private int song_genre_id;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private song song_id;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private genre genre_id;

    public song_genre() {

    }

    public song_genre(int song_genre_id, song song_id, genre genre_id) {
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

    public song getSong_id() {
        return song_id;
    }

    public void setSong_id(song song_id) {
        this.song_id = song_id;
    }

    public genre getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(genre genre_id) {
        this.genre_id = genre_id;
    }
}
