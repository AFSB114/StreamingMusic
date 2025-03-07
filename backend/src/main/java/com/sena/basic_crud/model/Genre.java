package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_genre_id")
    private Genre parentGenreId;

    @OneToMany(mappedBy = "genreId", cascade = CascadeType.ALL)
    private List<ArtistGenre> ArtistGenres;

    @OneToMany(mappedBy = "genreId", cascade = CascadeType.ALL)
    private List<SongGenre> SongGenres;

    public Genre() {

    }

    public Genre(int id, String name, String description, Genre parentGenreId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentGenreId = parentGenreId;
    }

    public int getId() {
        return id;
    }

    public void setId(int genre_id) {
        this.id = genre_id;
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

    public Genre getParentGenreId() {
        return parentGenreId;
    }

    public void setParentGenreId(Genre parent_genre_id) {
        this.parentGenreId = parent_genre_id;
    }
}
