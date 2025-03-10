package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.model.Genre;

public class ArtistGenreDTO {

    private int id;
    private Artist artistId;
    private Genre genreId;

    public ArtistGenreDTO(int id, Artist artistId, Genre genreId) {
        this.id = id;
        this.artistId = artistId;
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artistId) {
        this.artistId = artistId;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }
}
