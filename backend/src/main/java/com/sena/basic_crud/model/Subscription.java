package com.sena.basic_crud.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Calendar;

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

    public Subscription(User userId, SubscriptionPlan subscriptionPlanId, String paymentMethod) {
        this.userId = userId;
        this.subscriptionPlanId = subscriptionPlanId;
        this.startDate = Date.valueOf(LocalDate.now());
        this.renewalDate = this.setRenewalDate();
        this.status = "ACTIVE";
        this.paymentMethod = paymentMethod;
    }

    private Date setRenewalDate() {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(this.startDate);
        System.out.println(this.subscriptionPlanId.getDuration());
        calendar.add(Calendar.DAY_OF_MONTH, this.subscriptionPlanId.getDuration());

        return new Date(calendar.getTimeInMillis());
    }

    public int getId() {
        return id;
    }


    public User getUserId() {
        return userId;
    }

    public void setUserId(User user_id) {
        this.userId = user_id;
    }

    public SubscriptionPlan getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    public void setSubscriptionPlanId(SubscriptionPlan subscriptionPlan_id) {
        this.subscriptionPlanId = subscriptionPlan_id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date start_date) {
        this.startDate = start_date;
    }

    public java.util.Date getRenewalDate() {
        return renewalDate;
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
