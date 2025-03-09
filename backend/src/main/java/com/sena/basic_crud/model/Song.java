package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int songId;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album albumId;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artistId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "track_number")
    private int trackNumber;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "composer")
    private String composer;

    @Column(name = "lyrics", columnDefinition = "TEXT")
    private String lyrics;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "songId", cascade = CascadeType.ALL)
    private List<SongGenre> SongGenres;

    @OneToMany(mappedBy = "songId", cascade = CascadeType.ALL)
    private List<PlaylistSong> PlaylistSongs;

    @OneToMany(mappedBy = "songId", cascade = CascadeType.ALL)
    private List<Playback> Playbacks;

    public Song() {

    }

    public Song(int songId, Album albumId, Artist artistId, String title, int duration, int trackNumber, Date releaseDate, String composer, String lyrics, String fileUrl, String imageUrl) {
        this.songId = songId;
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

    public int getSongId() {
        return songId;
    }

    public void setSongId(int song_id) {
        this.songId = song_id;
    }

    public Album getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Album album_id) {
        this.albumId = album_id;
    }

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artist_id) {
        this.artistId = artist_id;
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

    public void setTrackNumber(int track_number) {
        this.trackNumber = track_number;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date release_date) {
        this.releaseDate = release_date;
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

    public void setFileUrl(String file_url) {
        this.fileUrl = file_url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
