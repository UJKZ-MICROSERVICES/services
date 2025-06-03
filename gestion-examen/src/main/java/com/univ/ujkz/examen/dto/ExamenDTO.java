package com.univ.ujkz.examen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamenDTO {
    private Long id;
    private String type;
    private LocalDate dateExamen;
    private Integer duree;
    private Long niveauId;
    private Long filiereId;
    private Long elementUEId;
}
