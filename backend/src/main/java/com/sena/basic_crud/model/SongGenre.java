package com.sena.basic_crud.model;

import jakarta.persistence.*;

@Entity(name = "song_genre")
public class SongGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song songId;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genreId;

    public SongGenre() {

    }

    public SongGenre(int id, Song songId, Genre genreId) {
        this.id = id;
        this.songId = songId;
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int song_genre_id) {
        this.id = song_genre_id;
    }

    public Song getSongId() {
        return songId;
    }

    public void setSongId(Song song_id) {
        this.songId = song_id;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genre_id) {
        this.genreId = genre_id;
    }
}
