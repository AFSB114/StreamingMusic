package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;

@Entity(name = "subscription")
public class subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private int subscription_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user_id;

    @ManyToOne
    @JoinColumn(name = "subscription_plan_id", nullable = false)
    private subscription_plan subscription_plan_id;

    @Column(name = "start_date", nullable = false)
    @ColumnDefault("CURRENT_DATE")
    private Date start_date;

    @Column(name = "renewal_date", nullable = false)
    private Date renewal_date;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "payment_method", length = 100)
    private String payment_method;

    public subscription() {

    }

    public subscription(int subscription_id, user user_id, subscription_plan subscription_plan_id, Date start_date, Date renewal_date, String status, String payment_method) {
        this.subscription_id = subscription_id;
        this.user_id = user_id;
        this.subscription_plan_id = subscription_plan_id;
        this.start_date = start_date;
        this.renewal_date = renewal_date;
        this.status = status;
        this.payment_method = payment_method;
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }

    public user getUser_id() {
        return user_id;
    }

    public void setUser_id(user user_id) {
        this.user_id = user_id;
    }

    public subscription_plan getSubscription_plan_id() {
        return subscription_plan_id;
    }

    public void setSubscription_plan_id(subscription_plan subscription_plan_id) {
        this.subscription_plan_id = subscription_plan_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getRenewal_date() {
        return renewal_date;
    }

    public void setRenewal_date(Date renewal_date) {
        this.renewal_date = renewal_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
}
