package com.sena.basic_crud.DTO;

import java.sql.Date;

public class subscriptionDTO {

    private int subscription_id;
    private int user_id;
    private int subscription_plan_id;
    private Date start_date;
    private Date renewal_date;
    private String status;
    private String payment_method;

    public subscriptionDTO(int subscription_id, int user_id, int subscription_plan_id, Date start_date, Date renewal_date, String status, String payment_method) {
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSubscription_plan_id() {
        return subscription_plan_id;
    }

    public void setSubscription_plan_id(int subscription_plan_id) {
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
