package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.Album;
import com.sena.basic_crud.model.Artist;

import java.sql.Date;

public class SongDTO {

    private int id;
    private Album albumId;
    private Artist artistId;
    private String title;
    private int duration;
    private int trackNumber;
    private Date releaseDate;
    private String composer;
    private String lyrics;
    private String fileUrl;
    private String imageUrl;

    public SongDTO(int id, Album albumId, Artist artistId, String title, int duration, int trackNumber, Date releaseDate, String composer, String lyrics, String fileUrl, String imageUrl) {
        this.id = id;
        this.albumId = albumId;
        this.artistId = artistId;
        this.title = title;
        this.duration = duration;
        this.trackNumber = trackNumber;
        this.releaseDate = releaseDate;
        this.composer = composer;
        this.lyrics = lyrics;
        this.fileUrl = fileUrl;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Album getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Album albumId) {
        this.albumId = albumId;
    }

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artistId) {
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
