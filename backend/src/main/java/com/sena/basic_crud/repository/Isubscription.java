package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Isubscription extends JpaRepository<subscription, Integer> {
}
