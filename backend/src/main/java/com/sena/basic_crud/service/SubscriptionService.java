package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SubscriptionDTO;
import com.sena.basic_crud.model.Subscription;
import com.sena.basic_crud.repository.ISubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    private ISubscription data;

    public ResponseDTO save(SubscriptionDTO subscriptionDTO) {
        ResponseDTO res;
        List<String> errors = validate(subscriptionDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            Subscription subscription = convertToModel(subscriptionDTO);
            data.save(subscription);
            res = ResponseDTO.ok("Request made successful, new Subscription created");
        }
        return res;
    }

    public List<Subscription> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<Subscription> subscription = data.findById(id);
        if (subscription.isPresent()) {
            res = ResponseDTO.ok("Subscription found", subscription.get());
        } else {
            res = ResponseDTO.error("Subscription with id: " + id + " not found");
        }
        return res;
    }

    public List<String> validate(SubscriptionDTO subscriptionDTO) {
        List<String> errors = new ArrayList<>();

        // Validar usuario
        if (subscriptionDTO.getUserId() == null) {
            errors.add("El usuario es obligatorio");
        }

        // Validar plan de suscripción
        if (subscriptionDTO.getSubscriptionPlanId() == null) {
            errors.add("El plan de suscripción es obligatorio");
        }

        // Validar estado
        if (subscriptionDTO.getStatus() == null || subscriptionDTO.getStatus().trim().isEmpty()) {
            errors.add("El estado es obligatorio");
        } else if (subscriptionDTO.getStatus().length() > 50) {
            errors.add("El estado no puede exceder los 50 caracteres");
        }

        // Validar método de pago
        if (subscriptionDTO.getPaymentMethod() != null && subscriptionDTO.getPaymentMethod().length() > 100) {
            errors.add("El método de pago no puede exceder los 100 caracteres");
        }

        return errors;
    }

    public Subscription convertToModel(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = new Subscription(
                subscriptionDTO.getUserId(),
                subscriptionDTO.getSubscriptionPlanId(),
                subscriptionDTO.getStatus(),
                subscriptionDTO.getPaymentMethod()
        );
        return subscription;
    }
}
