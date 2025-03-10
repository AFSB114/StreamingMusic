package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.Genre;
import com.sena.basic_crud.model.Song;

public class SongGenreDTO {

    private int id;
    private Song songId;
    private Genre genreId;

    public SongGenreDTO(int id, Song songId, Genre genreId) {
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

    public Song getSongId() {
        return songId;
    }

    public void setSongId(Song songId) {
        this.songId = songId;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }
}
