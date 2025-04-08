package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.Artist;
import com.sena.basic_crud.model.RecordLabel;

import java.sql.Date;

public class AlbumDTO {

    private int id;
    private Artist artistId;
    private RecordLabel recordLabelId;
    private String title;
    private Date releaseDate;
    private String coverUrl;
    private String type;
    private int totalDuration;
    private String description;

    public AlbumDTO(Artist artistId, RecordLabel recordLabelId, String title, Date releaseDate, String coverUrl, String type, String description) {
        this.artistId = artistId;
        this.recordLabelId = recordLabelId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.coverUrl = coverUrl;
        this.type = type;
        this.description = description;
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

    public RecordLabel getRecordLabelId() {
        return recordLabelId;
    }

    public void setRecordLabelId(RecordLabel recordLabelId) {
        this.recordLabelId = recordLabelId;
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

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
