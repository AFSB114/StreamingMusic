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
}
