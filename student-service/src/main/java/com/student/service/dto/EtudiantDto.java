package com.student.service.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

public class EtudiantDto {

	@NotEmpty	
    private String nom;
	@NotEmpty
    private String prenom;
	@NotEmpty
    private String telephone;
	
    private Date dateNaissance;
    
    private String filiaire_id;
    private String id;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getFiliaire_id() {
		return filiaire_id;
	}
	public void setFiliaire_id(String filiaire_id) {
		this.filiaire_id = filiaire_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
