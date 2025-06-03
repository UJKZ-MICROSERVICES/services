package com.univ.ujkz.examen.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "etudiant_id")
    private Long etudiantId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "examen_id")
    private Examen examen;
    private Float valeur;
}
