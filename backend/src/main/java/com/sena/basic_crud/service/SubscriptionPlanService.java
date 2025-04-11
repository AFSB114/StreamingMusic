package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.SubscriptionPlanDTO;
import com.sena.basic_crud.model.SubscriptionPlan;
import com.sena.basic_crud.repository.ISubscriptionPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionPlanService {
    @Autowired
    private ISubscriptionPlan data;

    public ResponseDTO save(SubscriptionPlanDTO planDTO) {
        ResponseDTO res;
        List<String> errors = validate(planDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            SubscriptionPlan plan = convertToModel(planDTO);
            data.save(plan);
            res = ResponseDTO.ok("Request made successful, new SubscriptionPlan created");
        }
        return res;
    }

    public List<SubscriptionPlan> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<SubscriptionPlan> plan = data.findById(id);
        if (plan.isPresent()) {
            res = ResponseDTO.ok("Subscription Plan found", plan.get());
        } else {
            res = ResponseDTO.error("Subscription Plan with id: "+ id +" not found");
        }
        return res;
    }

    public List<String> validate(SubscriptionPlanDTO planDTO) {
        List<String> errors = new ArrayList<>();

        // Validar nombre
        if (planDTO.getName() == null || planDTO.getName().trim().isEmpty()) {
            errors.add("El nombre es obligatorio");
        } else if (planDTO.getName().length() > 100) {
            errors.add("El nombre no puede exceder los 100 caracteres");
        }

        // Validar precio
        if (planDTO.getPrice() == null) {
            errors.add("El precio es obligatorio");
        } else if (planDTO.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            errors.add("El precio no puede ser negativo");
        }

        // Validar calidad de audio (opcional)
        if (planDTO.getAudioQuality() !=  0 && (planDTO.getAudioQuality() < 0 || planDTO.getAudioQuality() > 10)){
            errors.add("La calidad de audio debe estar entre 0 y 10");
        }

        return errors;
    }

    public SubscriptionPlan convertToModel(SubscriptionPlanDTO planDTO) {
        SubscriptionPlan plan = new SubscriptionPlan(
                planDTO.getName(),
                planDTO.getPrice(),
                planDTO.getDuration(),
                planDTO.getFeatures(),
                planDTO.getAudioQuality(),
                planDTO.isAllowsDownloads(),
                planDTO.isAdFree()
        );
        return plan;
    }
}
