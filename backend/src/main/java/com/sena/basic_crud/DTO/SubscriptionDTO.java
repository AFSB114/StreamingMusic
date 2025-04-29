package com.sena.basic_crud.DTO;

import com.sena.basic_crud.model.SubscriptionPlan;
import com.sena.basic_crud.model.User;

public class SubscriptionDTO {

    private User userId;
    private SubscriptionPlan subscriptionPlanId;
    private String paymentMethod;

    public SubscriptionDTO(User userId, SubscriptionPlan subscriptionPlanId, String paymentMethod) {
        this.userId = userId;
        this.subscriptionPlanId = subscriptionPlanId;
        this.paymentMethod = paymentMethod;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
