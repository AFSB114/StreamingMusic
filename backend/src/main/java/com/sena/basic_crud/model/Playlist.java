package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
import java.util.List;

@Entity(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "creation_date", nullable = false)
    @ColumnDefault("CURRENT_DATE")
    private Date creationDate;

    @Column(name = "is_public")
    @ColumnDefault("TRUE")
    private boolean isPublic;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "playlistId", cascade = CascadeType.ALL)
    private List<PlaylistSong> PlaylistSongs;

    public Playlist() {

    }

    public Playlist(int id, User userId, String name, String description, Date creationDate, boolean isPublic, String imageUrl) {
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

    public void setId(int playlist_id) {
        this.id = playlist_id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user) {
        this.userId = user;
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

    public void setCreationDate(Date creation_date) {
        this.creationDate = creation_date;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean is_public) {
        this.isPublic = is_public;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image_url) {
        this.imageUrl = image_url;
    }
}
