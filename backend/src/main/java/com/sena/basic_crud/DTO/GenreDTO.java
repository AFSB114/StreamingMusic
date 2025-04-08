package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.Genre;

public class GenreDTO {

    private int id;
    private String name;
    private String description;

    public GenreDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private int parent_genre_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
