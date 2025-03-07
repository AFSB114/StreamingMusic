package com.sena.basic_crud.DTO;

import java.sql.Date;

public class playlistDTO {

    private int playlist_id;
    private int user_id;
    private String name;
    private String description;
    private Date creation_date;
    private boolean is_public;
    private String image_url;

    public playlistDTO(int playlist_id, int user_id, String name, String description, Date creation_date, boolean is_public, String image_url) {
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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