package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.User;

import java.sql.Timestamp;

public class FavoriteDTO {

    private int id;
    private User userId;
    private String objectType;
    private int objectId;
    private Timestamp dateMarked;

    public FavoriteDTO(int id, User userId, String objectType, int objectId, Timestamp dateMarked) {
        this.id = id;
        this.userId = userId;
        this.objectType = objectType;
        this.objectId = objectId;
        this.dateMarked = dateMarked;
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

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public Timestamp getDateMarked() {
        return dateMarked;
    }

    public void setDateMarked(Timestamp dateMarked) {
        this.dateMarked = dateMarked;
    }
}
