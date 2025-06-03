package com.univ.ujkz.examen.controller;

import com.univ.ujkz.examen.dto.NoteDTO;
import com.univ.ujkz.examen.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService service;

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@RequestBody @Valid NoteDTO noteDTO) {
        return ResponseEntity.ok(this.service.createNote(noteDTO));
    }

    @PutMapping
    public ResponseEntity<Void> updateNote(@RequestBody @Valid NoteDTO noteDTO) {
        this.service.updateNote(noteDTO);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<NoteDTO>> findAll() {
        return ResponseEntity.ok(this.service.findAllNotes());
    }

    @GetMapping("/{note-id}")
    public ResponseEntity<NoteDTO> findById(@PathVariable("note-id") Long id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @DeleteMapping("/{note-id}")
    public ResponseEntity<Void> delete(@PathVariable("note-id") Long id) {
        this.service.deleteNote(id);
        return ResponseEntity.accepted().build();
    }
}
