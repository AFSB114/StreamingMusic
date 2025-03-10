package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.RecordLabelDTO;
import com.sena.basic_crud.service.RecordLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/record-label")
public class RecordLabelController {
    @Autowired
    private RecordLabelService recordLabelService;

    @PostMapping("/")
    private ResponseEntity<Object> registerRecordLabel(@RequestBody RecordLabelDTO recordLabel) {
        recordLabelService.save(recordLabel);
        return new ResponseEntity<>("Register OK", HttpStatus.OK);
    }
}
