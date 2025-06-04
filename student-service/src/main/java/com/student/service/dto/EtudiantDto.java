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
	@NotEmpty
    private Date dateNaissance;
	@NotEmpty
    private String codeFiliaire;
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
	
	
}
