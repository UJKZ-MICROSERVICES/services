package com.student.service.models;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Filiaire {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filiaireId;
	private String designation;
	
	@Column(unique = true)
    private String code;
    
    @OneToMany(mappedBy = "filiaire",  fetch = FetchType.LAZY ,  cascade =CascadeType.ALL )
    private List<Etudiant> etudiants  = new ArrayList<>();
    
	public Filiaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filiaire(int filiaireId, String designation, String code) {
		super();
		this.filiaireId = filiaireId;
		this.designation = designation;
		this.code = code;
	}


	public Filiaire(String designation, String code) {
		super();
		this.designation = designation;
		this.code = code;
	}

	public int getFiliaireId() {
		return filiaireId;
	}

	public void setFiliaireId(int id) {
		this.filiaireId = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	@Override
	public String toString() {
		return "Filiaire [id=" + filiaireId + ", designation=" + designation + ", code=" + code + "]";
	}
    
	
    
}
