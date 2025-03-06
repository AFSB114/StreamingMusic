package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
import java.util.List;

@Entity(name = "playlist")
public class playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private int playlist_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_date", nullable = false)
    @ColumnDefault("CURRENT_DATE")
    private Date creation_date;

    @Column(name = "is_public")
    @ColumnDefault("TRUE")
    private boolean is_public;

    @Column(name = "image_url")
    private String image_url;

    @OneToMany(mappedBy = "playlist_id", cascade = CascadeType.ALL)
    private List<playlist_song> playlist_songs;

    public playlist() {

    }

    public playlist(int playlist_id, user user_id, String name, String description, Date creation_date, boolean is_public, String image_url) {
        this.playlist_id = playlist_id;
        this.user_id = user_id;
        this.name = name;
        this.description = description;
        this.creation_date = creation_date;
        this.is_public = is_public;
        this.image_url = image_url;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public user getUser_id() {
        return user_id;
    }

    public void setUser_id(user user) {
        this.user_id = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public boolean isIs_public() {
        return is_public;
    }

    public void setIs_public(boolean is_public) {
        this.is_public = is_public;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
