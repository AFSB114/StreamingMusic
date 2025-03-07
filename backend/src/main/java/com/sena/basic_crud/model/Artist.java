package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "artist") //Indicate this class is an Entity
public class Artist {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    @Column(name = "id") // Column of the Entity
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "country_of_origin", length = 100)
    private String countryOfOrigin;

    @Column(name = "debut_date")
    private Date debutDate;

    @Column(name = "biography")
    private String biography;

    @Column(name = "image_url", length = 255, nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "artistId", cascade = CascadeType.ALL)
    private List<Album> Albums;

    @OneToMany(mappedBy = "artistId", cascade = CascadeType.ALL)
    private List<ArtistGenre> ArtistGenres;

    @OneToMany(mappedBy = "artistId", cascade = CascadeType.ALL)
    private List<Song> Songs;

    public Artist() {

    }

    public Artist(int id, String name, String type, String countryOfOrigin, Date debutDate, String biography, String imageUrl) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.countryOfOrigin = countryOfOrigin;
        this.debutDate = debutDate;
        this.biography = biography;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int artist_id) {
        this.id = artist_id;
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

    public void setCountryOfOrigin(String country_of_origin) {
        this.countryOfOrigin = country_of_origin;
    }

    public Date getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(Date debut_date) {
        this.debutDate = debut_date;
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

    public void setImageUrl(String image_url) {
        this.imageUrl = image_url;
    }
}
