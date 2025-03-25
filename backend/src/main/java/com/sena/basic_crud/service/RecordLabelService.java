package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.RecordLabelDTO;
import com.sena.basic_crud.model.RecordLabel;
import com.sena.basic_crud.repository.IRecordLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordLabelService {
    @Autowired
    private IRecordLabel data;

    public ResponseDTO save(RecordLabelDTO recordLabelDTO) {
        ResponseDTO res;
        List<String> errors = validate(recordLabelDTO);
        if (!errors.isEmpty()) {
            res = ResponseDTO.error("Request made wrong", errors);
        } else {
            RecordLabel recordLabel = convertToModel(recordLabelDTO);
            data.save(recordLabel);
            res = ResponseDTO.ok("Request made successful, new RecordLabel created");
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
