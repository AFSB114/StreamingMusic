package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity(name = "favorite")
public class favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private int favorite_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user_id;

    @Column(name = "object_type", nullable = false, length = 50)
    private String object_type;

    @Column(name = "object_id", nullable = false)
    private int object_id;

    @Column(name = "date_marked", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp date_marked;

    public favorite() {

    }

    public favorite(int favorite_id, user user_id, String object_type, int object_id, Timestamp date_marked) {
        this.favorite_id = favorite_id;
        this.user_id = user_id;
        this.object_type = object_type;
        this.object_id = object_id;
        this.date_marked = date_marked;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public user getUser_id() {
        return user_id;
    }

    public void setUser_id(user user_id) {
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
