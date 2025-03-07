package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.SubscriptionDTO;
import com.sena.basic_crud.model.Subscription;
import com.sena.basic_crud.repository.ISubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    private ISubscription data;

    public void save(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = convertToModel(subscriptionDTO);
        data.save(subscription);
    }

    public Subscription convertToModel(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = new Subscription(
                subscriptionDTO.getId(),
                subscriptionDTO.getUserId(),
                subscriptionDTO.getSubscriptionPlanId(),
                subscriptionDTO.getStartDate(),
                subscriptionDTO.getRenewalDate(),
                subscriptionDTO.getStatus(),
                subscriptionDTO.getPaymentMethod()
        );
        return subscription;
    }
}
