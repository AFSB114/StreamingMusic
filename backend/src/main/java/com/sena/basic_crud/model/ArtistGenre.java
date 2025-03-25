package com.sena.basic_crud.model;

import jakarta.persistence.*;

@Entity(name = "artist_genre")
public class ArtistGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false )
    private Artist artistId;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genreId;

    public ArtistGenre() {

    }

    public ArtistGenre(Artist artistId, Genre genreId) {
        this.artistId = artistId;
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int artist_genre_id) {
        this.id = artist_genre_id;
    }

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artist_id) {
        this.artistId = artist_id;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genre_id) {
        this.genreId = genre_id;
    }
}
