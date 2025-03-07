package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.SubscriptionPlan;
import com.sena.basic_crud.model.User;

import java.sql.Date;

public class SubscriptionDTO {

    private int id;
    private User userId;
    private SubscriptionPlan subscriptionPlanId;
    private Date startDate;
    private Date renewalDate;
    private String status;
    private String paymentMethod;

    public SubscriptionDTO(int id, User userId, SubscriptionPlan subscriptionPlanId, Date startDate, Date renewalDate, String status, String paymentMethod) {
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

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public SubscriptionPlan getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    public void setSubscriptionPlanId(SubscriptionPlan subscriptionPlanId) {
        this.subscriptionPlanId = subscriptionPlanId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
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

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
