package com.sena.basic_crud.DTO;

import java.sql.Date;

public class record_labelDTO {

    private int record_label_id;
    private String name;
    private String country;
    private Date foundation_date;
    private String website;
    private String logo_url;

    public record_labelDTO(int record_label_id, String name, String country, Date foundation_date, String website, String logo_url) {
        this.record_label_id = record_label_id;
        this.name = name;
        this.country = country;
        this.foundation_date = foundation_date;
        this.website = website;
        this.logo_url = logo_url;
    }

    public int getRecord_label_id() {
        return record_label_id;
    }

    public void setRecord_label_id(int record_label_id) {
        this.record_label_id = record_label_id;
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

    public Date getFoundation_date() {
        return foundation_date;
    }

    public void setFoundation_date(Date foundation_date) {
        this.foundation_date = foundation_date;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }
}
