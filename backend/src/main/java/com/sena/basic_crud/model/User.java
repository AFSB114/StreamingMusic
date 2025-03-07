package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
import java.util.List;

@Entity(name = "user_account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "registration_date", nullable = false)
    @ColumnDefault("CURRENT_DATE")
    private Date registrationDate;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Subscription> Subscriptions;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Playlist> Playlists;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Playback> Playbacks;

    public User() {

    }

    public User(int id, String name, String email, String password, Date registrationDate, String country, String profileImage) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.country = country;
        this.profileImage = profileImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int user_id) {
        this.id = user_id;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registration_date) {
        this.registrationDate = registration_date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profile_image) {
        this.profileImage = profile_image;
    }
}
