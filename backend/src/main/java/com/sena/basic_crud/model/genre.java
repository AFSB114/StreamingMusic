package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "genre")
public class genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int genre_id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_genre_id")
    private genre parent_genre_id;

    @OneToMany(mappedBy = "genre_id", cascade = CascadeType.ALL)
    private List<artist_genre> artist_genres;

    @OneToMany(mappedBy = "genre_id", cascade = CascadeType.ALL)
    private List<song_genre> song_genres;

    public  genre() {

    }

    public genre(int genre_id, String name, String description, genre parent_genre_id) {
        this.genre_id = genre_id;
        this.name = name;
        this.description = description;
        this.parent_genre_id = parent_genre_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
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

    public genre getParent_genre_id() {
        return parent_genre_id;
    }

    public void setParent_genre_id(genre parent_genre_id) {
        this.parent_genre_id = parent_genre_id;
    }
}
