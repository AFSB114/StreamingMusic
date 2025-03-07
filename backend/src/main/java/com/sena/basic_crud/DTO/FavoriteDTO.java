package com.sena.basic_crud.DTO;

import java.sql.Timestamp;

public class FavoriteDTO {

    private int id;
    private int userId;
    private String objectType;
    private int objectId;

    public FavoriteDTO(int id, int userId, String objectType, int objectId, Timestamp date_marked) {
        this.id = id;
        this.userId = userId;
        this.objectType = objectType;
        this.objectId = objectId;
        this.date_marked = date_marked;
    }

    private Timestamp date_marked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public Timestamp getDate_marked() {
        return date_marked;
    }

    public void setDate_marked(Timestamp date_marked) {
        this.date_marked = date_marked;
    }
}
