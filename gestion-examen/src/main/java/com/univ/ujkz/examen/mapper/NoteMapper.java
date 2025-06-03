package com.univ.ujkz.examen.mapper;

import com.univ.ujkz.examen.dto.NoteDTO;
import com.univ.ujkz.examen.model.Note;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class NoteMapper {

    public NoteDTO toDTO(Note note) {
        if (Objects.isNull(note)) {
            return null;
        }
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setExamenId(note.getExamen().getId());
        noteDTO.setEtudiantId(note.getEtudiantId());
        noteDTO.setValeur(note.getValeur());

        return noteDTO;
    }

    public Note toEntity(NoteDTO noteDTO) {
        if(Objects.isNull(noteDTO)) {
            return null;
        }

        Note note = new Note();
        note.setId(noteDTO.getId());
        note.setEtudiantId(noteDTO.getEtudiantId());
        note.setExamen(null);
        note.setValeur(noteDTO.getValeur());
        return note;
    }
}
