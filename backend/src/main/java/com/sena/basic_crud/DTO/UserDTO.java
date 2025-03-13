package com.sena.basic_crud.DTO;

import java.sql.Date;

public class UserDTO {

    private String name;
    private String email;
    private String password;
    private String country;
    private String profileImage;

    public UserDTO(String name, String email, String password, String country, String profileImage) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.profileImage = profileImage;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
