package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artistId;

    @ManyToOne
    @JoinColumn(name = "record_label_id", nullable = false)
    private RecordLabel recordLabelId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "cover_url")
    private String coverUrl;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "total_duration")
    private int totalDuration;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "albumId", cascade = CascadeType.ALL)
    private List<Song> Songs;

    public Album() {

    }

    public Album(Artist artistId, RecordLabel recordLabelId, String title, Date releaseDate, String coverUrl, String type, String description) {
        this.artistId = artistId;
        this.recordLabelId = recordLabelId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.coverUrl = coverUrl;
        this.type = type;
        this.totalDuration = 0;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int album_id) {
        this.id = album_id;
    }

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artist_id) {
        this.artistId = artist_id;
    }

    public RecordLabel getRecordLabelId() {
        return recordLabelId;
    }

    public void setRecordLabelId(RecordLabel recordLabel_id) {
        this.recordLabelId = recordLabel_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date release_date) {
        this.releaseDate = release_date;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String cover_url) {
        this.coverUrl = cover_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int total_duration) {
        this.totalDuration = total_duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
