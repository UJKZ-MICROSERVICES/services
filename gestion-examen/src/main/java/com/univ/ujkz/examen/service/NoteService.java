package com.univ.ujkz.examen.service;

import com.univ.ujkz.examen.dto.NoteDTO;
import com.univ.ujkz.examen.mapper.NoteMapper;
import com.univ.ujkz.examen.model.Note;
import com.univ.ujkz.examen.repository.ExamenRepository;
import com.univ.ujkz.examen.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;
    private final ExamenRepository examenRepository;
    private final NoteMapper mapper;

    public NoteDTO createNote(NoteDTO noteDTO) {
        var note = this.mapper.toEntity(noteDTO);
        note.setExamen(this.examenRepository.findById(noteDTO.getExamenId()).get());
        return this.mapper.toDTO(this.repository.save(note));
    }

    public void updateNote(NoteDTO noteDTO) {
        var note = this.repository.findById(noteDTO.getId())
                .orElseThrow(()-> new RuntimeException("Impossible de mettre à jour:: Aucune note trouvée avec l'identifiant " + noteDTO.getId()));
        mergeNoote(note, noteDTO);
        this.repository.save(note);
    }

    private void mergeNoote(Note note, NoteDTO noteDTO) {
        if(Objects.nonNull(noteDTO.getValeur())) {
            note.setValeur(noteDTO.getValeur());
        }
        if(Objects.nonNull(noteDTO.getEtudiantId())) {
            note.setEtudiantId(noteDTO.getEtudiantId());
        }
        if (Objects.nonNull(noteDTO.getExamenId())) {
            note.setExamen(this.examenRepository.findById(noteDTO.getExamenId()).get());
        }
    }

    public List<NoteDTO> findAllNotes() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toDTO)
                .collect(Collectors.toList());
    }

    public NoteDTO findById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Aucune note trouvée avec ID " + id));
    }

    public void deleteNote(Long id) {
        this.repository.deleteById(id);
    }
}
