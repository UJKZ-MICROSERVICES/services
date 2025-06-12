package com.student.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.service.models.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{

}
