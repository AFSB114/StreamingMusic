package com.sena.basic_crud.DTO;

import java.sql.Date;

public class AlbumDTO {

    private int id;
    private int artistId;
    private int recordLabelId;
    private String title;
    private Date releaseDate;
    private String coverUrl;
    private String type;
    private int totalDuration;
    private String description;

    public AlbumDTO(int id, int artistId, int recordLabelId, String title, Date releaseDate, String coverUrl, String type, int totalDuration, String description) {
        this.id = id;
        this.artistId = artistId;
        this.recordLabelId = recordLabelId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.coverUrl = coverUrl;
        this.type = type;
        this.totalDuration = totalDuration;
        this.description = description;
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

    public int getRecordLabelId() {
        return recordLabelId;
    }

    public void setRecordLabelId(int recordLabelId) {
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
