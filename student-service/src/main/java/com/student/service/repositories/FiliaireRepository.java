package com.student.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.service.models.Filiaire;

public interface FiliaireRepository extends JpaRepository<Filiaire, Integer>{

	public Filiaire findByCode(String code);
}
