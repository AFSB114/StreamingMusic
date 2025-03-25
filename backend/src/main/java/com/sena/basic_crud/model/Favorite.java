package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "object_type", nullable = false, length = 50)
    private String objectType;

    @Column(name = "object_id", nullable = false)
    private int objectId;

    @Column(name = "date_marked", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Timestamp dateMarked;

    public Favorite() {

    }

    public Favorite(User userId, String objectType, int objectId) {
        this.userId = userId;
        this.objectType = objectType;
        this.objectId = objectId;
        this.dateMarked = Timestamp.valueOf(LocalDateTime.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int favorite_id) {
        this.id = favorite_id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user_id) {
        this.userId = user_id;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String object_type) {
        this.objectType = object_type;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int object_id) {
        this.objectId = object_id;
    }

    public Timestamp getDateMarked() {
        return dateMarked;
    }

    public void setDateMarked(Timestamp date_marked) {
        this.dateMarked = date_marked;
    }
}
