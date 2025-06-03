package com.univ.ujkz.examen.mapper;

import com.univ.ujkz.examen.dto.ExamenDTO;
import com.univ.ujkz.examen.model.Examen;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ExamenMapper {

    public ExamenDTO toDTO(Examen examen) {
        if (Objects.isNull(examen)) {
            return null;
        }
        return new ExamenDTO(
                examen.getId(),
                examen.getType(),
                examen.getDateExamen(),
                examen.getDuree(),
                examen.getNiveauId(),
                examen.getFiliereId(),
                examen.getElementUEId()
        );
    }

    public Examen toEntity(ExamenDTO examenDTO) {
        if(Objects.isNull(examenDTO)) {
            return null;
        }

        return Examen.builder()
                .id(examenDTO.getId())
                .type(examenDTO.getType())
                .dateExamen(examenDTO.getDateExamen())
                .duree(examenDTO.getDuree())
                .filiereId(examenDTO.getFiliereId())
                .niveauId(examenDTO.getNiveauId())
                .elementUEId(examenDTO.getElementUEId())
        .build();
    }
}
