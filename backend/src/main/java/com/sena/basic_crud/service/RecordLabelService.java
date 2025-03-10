package com.sena.basic_crud.service;

import com.sena.basic_crud.DTO.RecordLabelDTO;
import com.sena.basic_crud.model.RecordLabel;
import com.sena.basic_crud.repository.IRecordLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordLabelService {
    @Autowired
    private IRecordLabel data;

    public void save(RecordLabelDTO recordLabelDTO) {
        RecordLabel recordLabel = convertToModel(recordLabelDTO);
        data.save(recordLabel);
    }

    public RecordLabel convertToModel(RecordLabelDTO recordLabelDTO) {
        return new RecordLabel(
                recordLabelDTO.getId(),
                recordLabelDTO.getName(),
                recordLabelDTO.getCountry(),
                recordLabelDTO.getFoundationDate(),
                recordLabelDTO.getWebsite(),
                recordLabelDTO.getLogoUrl()
        );
    }

    public RecordLabelDTO convertToDTO(RecordLabel recordLabel) {
        return new RecordLabelDTO(
                recordLabel.getId(),
                recordLabel.getName(),
                recordLabel.getCountry(),
                recordLabel.getFoundationDate(),
                recordLabel.getWebsite(),
                recordLabel.getLogoUrl()
        );
    }
}
