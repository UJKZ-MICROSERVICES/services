package com.univ.ujkz.examen.service;

import com.univ.ujkz.examen.dto.ExamenDTO;
import com.univ.ujkz.examen.mapper.ExamenMapper;
import com.univ.ujkz.examen.model.Examen;
import com.univ.ujkz.examen.repository.ExamenRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamenService {
    private final ExamenRepository repository;
    private final ExamenMapper mapper;

    public ExamenDTO createExamen(ExamenDTO examenDTO) {
        return this.mapper.toDTO(this.repository.save(this.mapper.toEntity(examenDTO)));
    }

    public void updateExamen(ExamenDTO examenDTO) {
        var examen = this.repository.findById(examenDTO.getId())
                .orElseThrow(() -> new RuntimeException("Impossible de mettre à jour:: Aucun examen trouvé avec l'identifiant " + examenDTO.getId()));
        mergeExamen(examen, examenDTO);
        this.repository.save(examen);
    }

    private void mergeExamen(Examen examen, ExamenDTO examenDTO) {
        if (StringUtils.isNotBlank(examenDTO.getType())) {
            examen.setType(examenDTO.getType());
        }
        if (Objects.nonNull(examenDTO.getDateExamen())) {
            examen.setDateExamen(examenDTO.getDateExamen());
        }
        if (Objects.nonNull(examenDTO.getDuree())) {
            examen.setDuree(examenDTO.getDuree());
        }
        if (Objects.nonNull(examenDTO.getFiliereId())) {
            examen.setFiliereId(examenDTO.getFiliereId());
        }
        if (Objects.nonNull(examenDTO.getNiveauId())) {
            examen.setNiveauId(examenDTO.getNiveauId());
        }
        if(Objects.nonNull(examenDTO.getElementUEId())) {
        	examen.setElementUEId(examenDTO.getElementUEId());
        }
    }

    public List<ExamenDTO> findAllExamens() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ExamenDTO findById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Aucun examen trouvé avec ID " + id));
    }

    public void deleteExamen(Long id) {
        this.repository.deleteById(id);
    }
}
