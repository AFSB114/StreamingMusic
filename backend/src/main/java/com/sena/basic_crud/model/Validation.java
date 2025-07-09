package com.sena.basic_crud.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class Validation {

    @Column(nullable = false)
    private boolean expired;

    @Column(nullable = false)
    private boolean locked;
}

