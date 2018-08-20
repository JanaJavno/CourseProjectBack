package com.example.req.service;

import com.example.req.domain.Manual;
import com.example.req.domain.ManualCategory;
import com.example.req.repository.ManualRepository;
import com.example.req.service.DTO.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManualService {
    private final ManualRepository manualRepository;

    public ManualService(ManualRepository manualRepository) {
        this.manualRepository = manualRepository;
    }

    public List<Manual> findAll() {
        return manualRepository.findAll();
    }

    public Manual createDefault (Manual manual) {
        return manualRepository.save(manual);
    }

    public List<Manual> findByType (String type) {
        return manualRepository.findAllByCategory(ManualCategory.valueOf(type));
    }

    public Manual update (Long manualId, Manual manualRequest) {
        return manualRepository.findById(manualId).map(manual -> {
            manual.setTitle(manualRequest.getTitle());
            manual.setUrl(manualRequest.getUrl());
            return manualRepository.save(manual);
        }).orElseThrow(() -> new ResourceNotFoundException("ManualId " + manualId + " not found"));
    }

    public ResponseEntity<?> delete (Long manualId) {
        return manualRepository.findById(manualId).map(manual -> {
            manualRepository.delete(manual);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ManualId " + manualId + " not found"));
    }
}
