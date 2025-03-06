package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "artist") //Indicate this class is an Entity
public class artist {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    @Column(name = "artist_id") // Column of the Entity
    private int artist_id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "country_of_origin", length = 100)
    private String country_of_origin;

    @Column(name = "debut_date")
    private Date debut_date;

    @Column(name = "biography")
    private String biography;

    @Column(name = "image_url", length = 255, nullable = false)
    private String image_url;

    @OneToMany(mappedBy = "artist_id", cascade = CascadeType.ALL)
    private List<album> albums;

    @OneToMany(mappedBy = "artist_id", cascade = CascadeType.ALL)
    private List<artist_genre> artist_genres;

    @OneToMany(mappedBy = "artist_id", cascade = CascadeType.ALL)
    private List<song> songs;

    public artist() {

    }

    public artist(int artist_id, String name, String type, String country_of_origin, Date debut_date, String biography, String image_url) {
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
