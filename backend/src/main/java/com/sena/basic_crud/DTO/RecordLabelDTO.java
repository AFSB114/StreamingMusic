package com.sena.basic_crud.DTO;

import java.sql.Date;

public class RecordLabelDTO {

    private int id;
    private String name;
    private String country;
    private Date foundationDate;
    private String website;
    private String logoUrl;

    public RecordLabelDTO(int id, String name, String country, Date foundationDate, String website, String logoUrl) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.foundationDate = foundationDate;
        this.website = website;
        this.logoUrl = logoUrl;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
