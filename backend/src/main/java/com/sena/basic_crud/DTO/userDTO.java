package com.sena.basic_crud.DTO;

import java.sql.Date;

public class userDTO {

    private int user_id;
    private String name;
    private String email;
    private String password;
    private Date registration_date;
    private String country;
    private String profile_image;

    public userDTO(int user_id, String name, String email, String password, Date registration_date, String country, String profile_image) {
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
