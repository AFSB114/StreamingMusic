package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.RecordLabelDTO;
import com.sena.basic_crud.model.RecordLabel;
import com.sena.basic_crud.repository.IRecordLabel;
import com.sena.basic_crud.specification.RecordLabelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordLabelService {

    private final IRecordLabel data;

    @Autowired
    public RecordLabelService(IRecordLabel data) {
        this.data = data;
    }

    public ResponseDTO save(RecordLabelDTO recordLabelDTO) {
        ResponseDTO res;
        List<String> errors = validate(recordLabelDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            RecordLabel recordLabel = convertToModel(recordLabelDTO);
            data.save(recordLabel);
            res = ResponseDTO.ok("Request made successful, new RecordLabel created", recordLabel);
        }
        return res;
    }

    public List<RecordLabel> findAll() {
        return data.findAll();
    }

    public ResponseDTO findById(int id) {
        ResponseDTO res;
        Optional<RecordLabel> recordLabel = data.findById(id);
        if (recordLabel.isPresent()) {
            res = ResponseDTO.ok("RecordLabel found", recordLabel.get());
        } else {
            res = ResponseDTO.error("RecordLabel with id: " + id + " not found");
        }
        return res;
    }

    public ResponseDTO search(String name, String country){
        Specification<RecordLabel> spec = Specification.where(RecordLabelSpecification.hasName(name)).and(RecordLabelSpecification.hasCountry(country));
        List<RecordLabel> recordLabels = data.findAll(spec);

        return ResponseDTO.ok("RecordLabels found", recordLabels);
    }

    public ResponseDTO update(int id,RecordLabelDTO recordLabelDTO) {
        Optional<RecordLabel> optionalRecordLabel = data.findById(id);

        if (!optionalRecordLabel.isPresent()) return ResponseDTO.error("RecordLabel with id: " + recordLabelDTO.getId() + " not found");

        RecordLabel currentRecordLabel = optionalRecordLabel.get();

        currentRecordLabel.setName((recordLabelDTO.getName() != null) ? recordLabelDTO.getName() : currentRecordLabel.getName());
        currentRecordLabel.setCountry(recordLabelDTO.getCountry() != null ? recordLabelDTO.getCountry() : currentRecordLabel.getCountry());
        currentRecordLabel.setFoundationDate((recordLabelDTO.getFoundationDate() != null) ? recordLabelDTO.getFoundationDate() : currentRecordLabel.getFoundationDate());
        currentRecordLabel.setWebsite((recordLabelDTO.getWebsite() != null) ? recordLabelDTO.getWebsite() : currentRecordLabel.getWebsite());
        currentRecordLabel.setLogoUrl((recordLabelDTO.getLogoUrl() != null) ? recordLabelDTO.getLogoUrl() : currentRecordLabel.getLogoUrl());

        data.save(currentRecordLabel);

        return ResponseDTO.ok("RecordLabel updated", currentRecordLabel);
    }

    public ResponseDTO delete(int id) {
        Optional<RecordLabel> recordLabel = data.findById(id);
        if (!recordLabel.isPresent()) return ResponseDTO.error("RecordLabel with id: " + id + " not found");
        data.deleteById(id);
        return ResponseDTO.ok("RecordLabel deleted");
    }

    public List<String> validate(RecordLabelDTO recordLabelDTO) {
        List<String> errors = new ArrayList<>();

        // Validar nombre
        if (recordLabelDTO.getName() == null || recordLabelDTO.getName().trim().isEmpty()) {
            errors.add("El nombre es obligatorio");
        }

        // Validar país
        if (recordLabelDTO.getCountry() != null && recordLabelDTO.getCountry().length() > 100) {
            errors.add("El país no puede exceder los 100 caracteres");
        }

        // Validar URL del sitio web
        if (recordLabelDTO.getWebsite() != null && recordLabelDTO.getWebsite().length() > 255) {
            errors.add("La URL del sitio web no puede exceder los 255 caracteres");
        }

        // Validar URL del logo
        if (recordLabelDTO.getLogoUrl() != null && recordLabelDTO.getLogoUrl().length() > 255) {
            errors.add("La URL del logo no puede exceder los 255 caracteres");
        }

        return errors;
    }

    public RecordLabel convertToModel(RecordLabelDTO recordLabelDTO) {
        RecordLabel recordLabel = new RecordLabel(
                recordLabelDTO.getName(),
                recordLabelDTO.getCountry(),
                recordLabelDTO.getFoundationDate(),
                recordLabelDTO.getWebsite(),
                recordLabelDTO.getLogoUrl()
        );
        return recordLabel;
    }
}
