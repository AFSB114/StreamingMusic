package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.User;

import java.sql.Date;

public class PlaylistDTO {

    private User userId;
    private String name;
    private String description;
    private boolean isPublic;
    private String imageUrl;

    public PlaylistDTO(User userId, String name, String description, boolean isPublic, String imageUrl) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.isPublic = isPublic;
        this.imageUrl = imageUrl;
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}