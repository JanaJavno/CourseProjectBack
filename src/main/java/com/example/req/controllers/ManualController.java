package com.example.req.controllers;

import com.example.req.domain.Manual;
import com.example.req.repository.ManualRepository;
import com.example.req.service.DTO.ResourceNotFoundException;
import com.example.req.service.ManualService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/manuals")
public class ManualController {

    private final ManualService manualService;

    public ManualController(ManualService manualService) {
        this.manualService = manualService;
    }

    @GetMapping("/")
    public List<Manual> getAllManuals() {
        return manualService.findAll();
    }

    @PostMapping("/")
    public Manual createManual(@Valid @RequestBody Manual manual) {
        return manualService.createDefault(manual);
    }

    @GetMapping("/category/{type}")
    public List<Manual> getTypedManuals(@PathVariable String type) {
        return manualService.findByType(type);
    }

    @PutMapping("/{manualId}")
    public Manual updateManual(@PathVariable Long manualId, @Valid @RequestBody Manual manualRequest) {
        return manualService.update(manualId, manualRequest);
    }

    @DeleteMapping("/{manualId}")
    public ResponseEntity<?> deleteManual(@PathVariable Long manualId) {
        return manualService.delete(manualId);
    }

}
