package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubscription extends JpaRepository<Subscription, Integer> {
}
