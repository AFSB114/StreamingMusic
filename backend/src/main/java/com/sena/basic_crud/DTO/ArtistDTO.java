package com.sena.basic_crud.DTO;

import java.sql.Date;

public class ArtistDTO {

    private String name;
    private String type;
    private String countryOfOrigin;
    private Date debutDate;
    private String biography;
    private String imageUrl;

    public ArtistDTO(String name, String type, String countryOfOrigin, Date debutDate, String biography, String imageUrl) {
        this.name = name;
        this.type = type;
        this.countryOfOrigin = countryOfOrigin;
        this.debutDate = debutDate;
        this.biography = biography;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Date getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(Date debutDate) {
        this.debutDate = debutDate;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
