package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;

@Entity(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "subscription_plan_id", nullable = false)
    private SubscriptionPlan subscriptionPlanId;

    @Column(name = "start_date", nullable = false)
    @ColumnDefault("CURRENT_DATE")
    private Date startDate;

    @Column(name = "renewal_date", nullable = false)
    private Date renewalDate;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "payment_method", length = 100)
    private String paymentMethod;

    public Subscription() {

    }

    public Subscription(int id, User userId, SubscriptionPlan subscriptionPlanId, Date startDate, Date renewalDate, String status, String paymentMethod) {
        this.id = id;
        this.userId = userId;
        this.subscriptionPlanId = subscriptionPlanId;
        this.startDate = startDate;
        this.renewalDate = renewalDate;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int subscription_id) {
        this.id = subscription_id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user_id) {
        this.userId = user_id;
    }

    public SubscriptionPlan getSubscription_plan_id() {
        return subscriptionPlanId;
    }

    public void setSubscription_plan_id(SubscriptionPlan subscriptionPlan_id) {
        this.subscriptionPlanId = subscriptionPlan_id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date start_date) {
        this.startDate = start_date;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewal_date) {
        this.renewalDate = renewal_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String payment_method) {
        this.paymentMethod = payment_method;
    }
}
