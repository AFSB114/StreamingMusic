package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;

@Entity(name = "user_account")
public class user_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "registration_date", nullable = false)
    @ColumnDefault("CURRENT_DATE")
    private Date registration_date;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "profile_image", length = 255)
    private String profile_image;
}
