package com.sena.basic_crud.DTO;

public class genreDTO {

    private int genre_id;
    private String name;
    private String description;

    public genreDTO(int genre_id, String name, String description, int parent_genre_id) {
        this.genre_id = genre_id;
        this.name = name;
        this.description = description;
        this.parent_genre_id = parent_genre_id;
    }

    private int parent_genre_id;

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

    public int getParent_genre_id() {
        return parent_genre_id;
    }

    public void setParent_genre_id(int parent_genre_id) {
        this.parent_genre_id = parent_genre_id;
    }
}
