package com.sena.basic_crud.controller;

import com.sena.basic_crud.DTO.ResponseDTO;
import com.sena.basic_crud.DTO.RecordLabelDTO;
import com.sena.basic_crud.model.RecordLabel;
import com.sena.basic_crud.service.RecordLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/record-label")
public class RecordLabelController {

    private final RecordLabelService recordLabelService;

    @Autowired
    public RecordLabelController(RecordLabelService recordLabelService) {
        this.recordLabelService = recordLabelService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addRecordLabel(@RequestBody RecordLabelDTO recordLabel) {
        ResponseDTO res = recordLabelService.save(recordLabel);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllRecordLabels() {
        List<RecordLabel> recordLabels = recordLabelService.findAll();
        return new ResponseEntity(recordLabels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRecordLabelById(@PathVariable int id) {
        ResponseDTO res = recordLabelService.findById(id);
        return new ResponseEntity(res, res.getStatus());
    }

    @GetMapping("/search")
    public ResponseEntity<Object> getArtistByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String country
    ) {
        ResponseDTO res = recordLabelService.search(name, country);
        return new ResponseEntity(res, res.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRecordLabel(@PathVariable int id) {
        ResponseDTO res = recordLabelService.delete(id);
        return new ResponseEntity(res, res.getStatus());
    }

    @PutMapping(value = "/{id}", consumes = {"application/json"})
    public ResponseEntity<Object> updateRecordLabel(
            @PathVariable int id,
            @RequestBody RecordLabelDTO recordLabel
    ) {
        ResponseDTO res = recordLabelService.update(id, recordLabel);
        return new ResponseEntity(res, res.getStatus());
    }
}
