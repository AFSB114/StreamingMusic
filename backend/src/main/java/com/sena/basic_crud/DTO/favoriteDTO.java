package com.sena.basic_crud.DTO;

import java.sql.Timestamp;

public class favoriteDTO {

    private int favorite_id;
    private int user_id;
    private String object_type;
    private int object_id;

    public favoriteDTO(int favorite_id, int user_id, String object_type, int object_id, Timestamp date_marked) {
        this.favorite_id = favorite_id;
        this.user_id = user_id;
        this.object_type = object_type;
        this.object_id = object_id;
        this.date_marked = date_marked;
    }

    private Timestamp date_marked;

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getObject_type() {
        return object_type;
    }

    public void setObject_type(String object_type) {
        this.object_type = object_type;
    }

    public int getObject_id() {
        return object_id;
    }

    public void setObject_id(int object_id) {
        this.object_id = object_id;
    }

    public Timestamp getDate_marked() {
        return date_marked;
    }

    public void setDate_marked(Timestamp date_marked) {
        this.date_marked = date_marked;
    }
}
