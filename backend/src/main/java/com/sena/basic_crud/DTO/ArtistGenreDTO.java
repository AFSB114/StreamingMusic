package com.sena.basic_crud.DTO;

public class ArtistGenreDTO {

    private int id;
    private int artistId;
    private int genreId;

    public ArtistGenreDTO(int id, int artistId, int genreId) {
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

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
