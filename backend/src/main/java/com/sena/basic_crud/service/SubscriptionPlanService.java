package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.SubscriptionPlanDTO;
import com.sena.basic_crud.model.SubscriptionPlan;
import com.sena.basic_crud.repository.ISubscriptionPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionPlanService {
    @Autowired
    private ISubscriptionPlan data;

    public void save(SubscriptionPlanDTO planDTO) {
        SubscriptionPlan plan = convertToModel(planDTO);
        data.save(plan);
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
