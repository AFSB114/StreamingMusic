package com.sena.basic_crud.DTO;

import java.math.BigDecimal;

public class SubscriptionPlanDTO {

    private String name;
    private BigDecimal price;
    private int duration;
    private String features;
    private int audioQuality;
    private boolean allowsDownloads;
    private boolean adFree;

    public SubscriptionPlanDTO() {
    }

    public SubscriptionPlanDTO(String name, BigDecimal price, int duration, String features, int audioQuality, boolean allowsDownloads, boolean adFree) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.features = features;
        this.audioQuality = audioQuality;
        this.allowsDownloads = allowsDownloads;
        this.adFree = adFree;
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
