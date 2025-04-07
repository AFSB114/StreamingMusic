package com.sena.basic_crud.repository;

import com.sena.basic_crud.model.RecordLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRecordLabel extends JpaRepository<RecordLabel,Integer>, JpaSpecificationExecutor<RecordLabel> {
}
