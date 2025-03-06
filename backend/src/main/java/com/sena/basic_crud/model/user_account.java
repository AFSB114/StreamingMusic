package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<subscription> subscriptions;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<playlist> playlists;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<playback> playbacks;

    public user_account() {

    }

    public user_account(int user_id, String name, String email, String password, Date registration_date, String country, String profile_image) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registration_date = registration_date;
        this.country = country;
        this.profile_image = profile_image;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
