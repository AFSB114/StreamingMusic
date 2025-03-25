package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "record_label")
public class RecordLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "foundation_date")
    private Date foundationDate;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "logo_url", length = 255)
    private String logoUrl;

    public RecordLabel() {

    }

    public RecordLabel(String name, String country, Date foundationDate, String website, String logoUrl) {
        this.name = name;
        this.country = country;
        this.foundationDate = foundationDate;
        this.website = website;
        this.logoUrl = logoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int record_label_id) {
        this.id = record_label_id;
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

    public void setFoundationDate(Date foundation_date) {
        this.foundationDate = foundation_date;
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

    public void setLogoUrl(String logo_url) {
        this.logoUrl = logo_url;
    }
}
