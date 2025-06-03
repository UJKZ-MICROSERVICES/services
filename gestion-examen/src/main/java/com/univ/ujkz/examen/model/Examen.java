package com.univ.ujkz.examen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "examens")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @Column(name = "date_examen")
    private LocalDate dateExamen;
    private Integer duree;
    @Column(name = "niveau_id")
    private Long niveauId;
    @Column(name = "filiere_id")
    private Long filiereId;
    @Column(name = "element_ue_id")
    private Long elementUEId;
    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Note> notes;
}
