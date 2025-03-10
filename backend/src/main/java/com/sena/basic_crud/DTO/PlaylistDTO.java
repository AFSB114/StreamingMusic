package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.User;

import java.sql.Date;

public class PlaylistDTO {

    private int id;
    private User userId;
    private String name;
    private String description;
    private Date creationDate;
    private boolean isPublic;
    private String imageUrl;

    public PlaylistDTO(int id, User userId, String name, String description, Date creationDate, boolean isPublic, String imageUrl) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.isPublic = isPublic;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        this.isPublic = aPublic;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}