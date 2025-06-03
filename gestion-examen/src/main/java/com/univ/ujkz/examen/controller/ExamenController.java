package com.univ.ujkz.examen.controller;

import com.univ.ujkz.examen.dto.ExamenDTO;
import com.univ.ujkz.examen.service.ExamenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/examens")
@RequiredArgsConstructor
public class ExamenController {

    private final ExamenService examenService;

    @PostMapping
    public ResponseEntity<ExamenDTO> createExamen(@RequestBody @Valid ExamenDTO examenDTO) {
        return ResponseEntity.ok(this.examenService.createExamen(examenDTO));
    }

    @PutMapping
    public ResponseEntity<Void> updateExamen(@RequestBody @Valid ExamenDTO examenDTO) {
        this.examenService.updateExamen(examenDTO);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<ExamenDTO>> findAll() {
        return ResponseEntity.ok(this.examenService.findAllExamens());
    }

    @GetMapping("/{examen-id}")
    public ResponseEntity<ExamenDTO> findById(@PathVariable("examen-id") Long id) {
        return ResponseEntity.ok(this.examenService.findById(id));
    }

    @DeleteMapping("/{examen-id}")
    public ResponseEntity<Void> delete(@PathVariable("examen-id") Long id) {
        this.examenService.deleteExamen(id);
        return ResponseEntity.accepted().build();
    }
}
