package com.univ.ujkz.examen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteDTO {
    private Long id;
    private Long etudiantId;
    private Long examenId;
    private Float valeur;
}
