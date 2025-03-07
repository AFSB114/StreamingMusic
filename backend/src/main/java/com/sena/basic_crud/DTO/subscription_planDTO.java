package com.sena.basic_crud.DTO;

import java.math.BigDecimal;

public class subscription_planDTO {

    private int plan_id;
    private String name;
    private BigDecimal price;
    private String duration;
    private String features;
    private int audio_quality;
    private boolean allows_downloads;
    private boolean ad_free;

    public subscription_planDTO(int plan_id, String name, BigDecimal price, String duration, String features, int audio_quality, boolean allows_downloads, boolean ad_free) {
        this.plan_id = plan_id;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.features = features;
        this.audio_quality = audio_quality;
        this.allows_downloads = allows_downloads;
        this.ad_free = ad_free;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public int getAudio_quality() {
        return audio_quality;
    }

    public void setAudio_quality(int audio_quality) {
        this.audio_quality = audio_quality;
    }

    public boolean isAllows_downloads() {
        return allows_downloads;
    }

    public void setAllows_downloads(boolean allows_downloads) {
        this.allows_downloads = allows_downloads;
    }

    public boolean isAd_free() {
        return ad_free;
    }

    public void setAd_free(boolean ad_free) {
        this.ad_free = ad_free;
    }
}
