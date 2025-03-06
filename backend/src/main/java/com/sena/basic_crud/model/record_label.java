package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "record_label")
public class record_label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_label_id")
    private int record_label_id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "foundation_date")
    private Date foundation_date;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "logo_url", length = 255)
    private String logo_url;
}
