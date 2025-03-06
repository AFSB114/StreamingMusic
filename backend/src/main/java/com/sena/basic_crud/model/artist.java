package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "artist") //Indicate this class is an Entity
public class artist {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    @Column(name = "artist_id") // Column of the Entity
    private int artist_id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "country_of_origin", length = 100)
    private String country_of_origin;

    @Column(name = "debut_date")
    private Date debut_date;

    @Column(name = "biography")
    private String biography;

    @Column(name = "image_url", length = 255, nullable = false)
    private String image_url;
}
