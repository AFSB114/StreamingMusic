package com.sena.basic_crud.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "subscription_plan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "features", columnDefinition = "TEXT")
    private String features;

    @Column(name = "audio_quality")
    private int audioQuality;

    @Column(name = "allows_downloads")
    private boolean allowsDownloads;

    @Column(name = "ad_free")
    private boolean adFree;

    @OneToMany(mappedBy = "subscriptionPlanId", cascade = CascadeType.ALL)
    private List<Subscription> Subscriptions;

    public SubscriptionPlan() {

    }

    public SubscriptionPlan(String name, BigDecimal price, int duration, String features, int audioQuality, boolean allowsDownloads, boolean adFree) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.features = features;
        this.audioQuality = audioQuality;
        this.allowsDownloads = allowsDownloads;
        this.adFree = adFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int planId) {
        this.id = planId;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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
