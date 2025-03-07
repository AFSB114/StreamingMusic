package com.sena.basic_crud.DTO;

import java.sql.Date;

public class artistDTO {

    private int artist_id;
    private String name;
    private String type;
    private String country_of_origin;
    private Date debut_date;
    private String biography;
    private String image_url;

    public artistDTO(int artist_id, String name, String type, String country_of_origin, Date debut_date, String biography, String image_url) {
        this.artist_id = artist_id;
        this.name = name;
        this.type = type;
        this.country_of_origin = country_of_origin;
        this.debut_date = debut_date;
        this.biography = biography;
        this.image_url = image_url;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
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

    public String getCountry_of_origin() {
        return country_of_origin;
    }

    public void setCountry_of_origin(String country_of_origin) {
        this.country_of_origin = country_of_origin;
    }

    public Date getDebut_date() {
        return debut_date;
    }

    public void setDebut_date(Date debut_date) {
        this.debut_date = debut_date;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
