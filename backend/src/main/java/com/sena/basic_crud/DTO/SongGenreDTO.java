package com.sena.basic_crud.DTO;

public class SongGenreDTO {

    private int id;
    private int songId;
    private int genreId;

    public SongGenreDTO(int id, int songId, int genreId) {
        this.id = id;
        this.songId = songId;
        this.genreId = genreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
