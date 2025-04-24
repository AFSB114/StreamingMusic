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
            res = ResponseDTO.ok("Request made successful, new SubscriptionPlan created", plan);
        }
        return res;
    }

    public List<SubscriptionPlan> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<SubscriptionPlan> plan = data.findById(id);
        if (plan.isPresent()) return ResponseDTO.ok("Subscription Plan found", plan.get());

        return ResponseDTO.error("Subscription Plan with id: "+ id +" not found");
    }

    public ResponseDTO delete(int id) {
        Optional<SubscriptionPlan> plan = data.findById(id);
        if (plan.isEmpty()) return  ResponseDTO.error("Subscription Plan with id: "+ id +" not found");
        data.deleteById(id);
        return ResponseDTO.ok("Subscription Plan deleted");
    }

    public ResponseDTO update(int id, SubscriptionPlanDTO planDTO) {
        Optional<SubscriptionPlan> plan = data.findById(id);

        if (plan.isEmpty()) return ResponseDTO.error("Subscription Plan with id: "+ id +" not found");

        SubscriptionPlan currentPlan = plan.get();

        currentPlan.setName(planDTO.getName() != null ? planDTO.getName() : currentPlan.getName());
        currentPlan.setPrice(planDTO.getPrice() != null ? planDTO.getPrice() : currentPlan.getPrice());
        currentPlan.setDuration(planDTO.getDuration() != 0 ? planDTO.getDuration() : currentPlan.getDuration());
        currentPlan.setFeatures(planDTO.getFeatures() != null ? planDTO.getFeatures() : currentPlan.getFeatures());
        currentPlan.setAudioQuality(planDTO.getAudioQuality() != 0 ? planDTO.getAudioQuality() : currentPlan.getAudioQuality());
        currentPlan.setAllowsDownloads(planDTO.isAllowsDownloads() != currentPlan.isAllowsDownloads() ? planDTO.isAllowsDownloads() : currentPlan.isAllowsDownloads());
        currentPlan.setAdFree(planDTO.isAdFree() != currentPlan.isAdFree() ? planDTO.isAdFree() : currentPlan.isAdFree());

        data.save(currentPlan);

        return ResponseDTO.ok("Subscription Plan updated successfully", currentPlan);
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
