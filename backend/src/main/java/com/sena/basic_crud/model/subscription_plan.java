package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity(name = "subscription_plan")
public class subscription_plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private int planId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "duration", length = 50, nullable = false)
    private String duration;

    @Column(name = "features")
    private String features;

    @Column(name = "audio_quality")
    private int audioQuality;

    @Column(name = "allows_downloads")
    private boolean allowsDownloads;

    @Column(name = "ad_free")
    private boolean adFree;

    public subscription_plan() {

    }

    public subscription_plan(int planId, String name, BigDecimal price, String duration, String features, int audioQuality, boolean allowsDownloads, boolean adFree) {
        this.planId = planId;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.features = features;
        this.audioQuality = audioQuality;
        this.allowsDownloads = allowsDownloads;
        this.adFree = adFree;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
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

    public int getAudioQuality() {
        return audioQuality;
    }

    public void setAudioQuality(int audioQuality) {
        this.audioQuality = audioQuality;
    }

    public boolean isAllowsDownloads() {
        return allowsDownloads;
    }

    public void setAllowsDownloads(boolean allowsDownloads) {
        this.allowsDownloads = allowsDownloads;
    }

    public boolean isAdFree() {
        return adFree;
    }

    public void setAdFree(boolean adFree) {
        this.adFree = adFree;
    }
}
