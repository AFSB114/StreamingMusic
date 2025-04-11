package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ISubscriptionPlan extends JpaRepository<SubscriptionPlan, Integer>, JpaSpecificationExecutor<SubscriptionPlan> {
}
