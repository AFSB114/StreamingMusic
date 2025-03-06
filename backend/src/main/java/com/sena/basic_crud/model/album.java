package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "album")
public class album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private int album_id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private artist artist_id;

    @ManyToOne
    @JoinColumn(name = "record_label_id", nullable = false)
    private record_label record_label_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date", nullable = false)
    private Date release_date;

    @Column(name = "cover_url")
    private String cover_url;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "total_duration")
    private int total_duration;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "album_id", cascade = CascadeType.ALL)
    private List<song> songs;

    public album() {

    }

    public album(int album_id, artist artist_id, record_label record_label_id, String title, Date release_date, String cover_url, String type, int total_duration, String description) {
        this.album_id = album_id;
        this.artist_id = artist_id;
        this.record_label_id = record_label_id;
        this.title = title;
        this.release_date = release_date;
        this.cover_url = cover_url;
        this.type = type;
        this.total_duration = total_duration;
        this.description = description;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public artist getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(artist artist_id) {
        this.artist_id = artist_id;
    }

    public record_label getRecord_label_id() {
        return record_label_id;
    }

    public void setRecord_label_id(record_label record_label_id) {
        this.record_label_id = record_label_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal_duration() {
        return total_duration;
    }

    public void setTotal_duration(int total_duration) {
        this.total_duration = total_duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
