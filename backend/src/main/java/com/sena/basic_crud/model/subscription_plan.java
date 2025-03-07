package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "subscription_plan")
public class subscription_plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private int plan_id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "duration", length = 50, nullable = false)
    private String duration;

    @Column(name = "features")
    private String features;

    @Column(name = "audio_quality")
    private int audio_quality;

    @Column(name = "allows_downloads")
    private boolean allows_downloads;

    @Column(name = "ad_free")
    private boolean ad_free;

    @OneToMany(mappedBy = "subscription_plan_id", cascade = CascadeType.ALL)
    private List<subscription> subscriptions;

    public subscription_plan() {

    }

    public subscription_plan(int plan_id, String name, BigDecimal price, String duration, String features, int audio_quality, boolean allows_downloads, boolean ad_free) {
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

    public void setPlan_id(int planId) {
        this.plan_id = planId;
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

    public void setAudio_quality(int audioQuality) {
        this.audio_quality = audioQuality;
    }

    public boolean isAllows_downloads() {
        return allows_downloads;
    }

    public void setAllows_downloads(boolean allowsDownloads) {
        this.allows_downloads = allowsDownloads;
    }

    public boolean isAd_free() {
        return ad_free;
    }

    public void setAd_free(boolean adFree) {
        this.ad_free = adFree;
    }
}
