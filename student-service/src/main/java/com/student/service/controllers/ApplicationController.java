package com.student.service.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.dto.EtudiantDto;
import com.student.service.dto.FiliaireDto;
import com.student.service.models.Etudiant;
import com.student.service.models.Filiaire;
import com.student.service.repositories.EtudiantRepository;
import com.student.service.repositories.FiliaireRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private FiliaireRepository filiaireRepository;

	@GetMapping("/etudiants")
	public ResponseEntity<Object> lesEtudiants() {

		try {
			List<Etudiant> userList = new ArrayList<>();
			etudiantRepository.findAll().forEach(userList::add);
			Filiaire f = new  Filiaire(1,"Master Informatique - Système d'information en Entreprise","MISIE");
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/etudiants")
	public ResponseEntity<Object> creerEtudiant(@Valid @RequestBody EtudiantDto etudiantDto, BindingResult result) {

		if (result.hasErrors()) {
			var errorsList = result.getAllErrors();
			var errorsMap = new HashMap<String, String>();

			for (int i = 0; i < errorsList.size(); i++) {
				var error = (FieldError) errorsList.get(i);
				errorsMap.put(error.getField(), error.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errorsMap);
		}

		try {
			//Customer customer = customerRepositoriy.findByUsername(ticketDto.getUsername());

			//if (customer == null) {
			//	return ResponseEntity.badRequest().body("No user found");
			//}
			/*
			 * otherCustomer = customerRepositoriy.findByEmail(customerDto.getEmail());
			 * if(otherCustomer != null) { return
			 * ResponseEntity.badRequest().body("Ce email est indisponible"); }
			 */

			Etudiant etudiant = new Etudiant(etudiantDto.getNom(),etudiantDto.getPrenom(),etudiantDto.getTelephone(),etudiantDto.getDateNaissance());

			//ticket.setCreatedAt(new Date());
			//ticket.setStatus("Pending");
			//System.out.println(ticket.getStatus());
			etudiant.setNumINE(UUID.randomUUID().toString());
			etudiantRepository.save(etudiant);
			//ticket.setCustomer(null);
			/*
			 * customer.getWallets().forEach((w)->{ w.setWalletType(new
			 * WalletType(w.getWalletType().getWtpId(),w.getWalletType().getWtpLabel(),w.
			 * getWalletType().getCurrency(),w.getWalletType().getIcon())); });
			 */

			var response = new HashMap<String, Object>();
			response.put("etudiant", etudiant);
			//System.out.println(ticket);

			return ResponseEntity.ok(response);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("une exception");
			ex.printStackTrace();
		}

		return ResponseEntity.badRequest().body("Error");
	}
	
	@PostMapping("/filiaires")
	public ResponseEntity<Object> creerFiliaire(@Valid @RequestBody FiliaireDto filiaireDto, BindingResult result) {

		if (result.hasErrors()) {
			var errorsList = result.getAllErrors();
			var errorsMap = new HashMap<String, String>();

			for (int i = 0; i < errorsList.size(); i++) {
				var error = (FieldError) errorsList.get(i);
				errorsMap.put(error.getField(), error.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errorsMap);
		}

		try {
			//Customer customer = customerRepositoriy.findByUsername(ticketDto.getUsername());

			//if (customer == null) {
			//	return ResponseEntity.badRequest().body("No user found");
			//}
			/*
			 * otherCustomer = customerRepositoriy.findByEmail(customerDto.getEmail());
			 * if(otherCustomer != null) { return
			 * ResponseEntity.badRequest().body("Ce email est indisponible"); }
			 */

			Filiaire filiaire = new Filiaire(filiaireDto.getDesignation(),filiaireDto.getCode());

			//ticket.setCreatedAt(new Date());
			//ticket.setStatus("Pending");
			//System.out.println(ticket.getStatus());
			filiaireRepository.save(filiaire);
			//ticket.setCustomer(null);
			/*
			 * customer.getWallets().forEach((w)->{ w.setWalletType(new
			 * WalletType(w.getWalletType().getWtpId(),w.getWalletType().getWtpLabel(),w.
			 * getWalletType().getCurrency(),w.getWalletType().getIcon())); });
			 */

			var response = new HashMap<String, Object>();
			response.put("filiaire", filiaire);
			//System.out.println(ticket);

			return ResponseEntity.ok(response);

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("une exception");
			ex.printStackTrace();
		}

		return ResponseEntity.badRequest().body("Error");
	}
	
	@GetMapping("/filiaires")
	public ResponseEntity<Object> lesFiliaires() {

		try {
			List<Filiaire> userList = new ArrayList<>();
			filiaireRepository.findAll().forEach(userList::add);
			//Filiaire f = new  Filiaire(1,"Master Informatique - Système d'information en Entreprise","MISIE");
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/filiaires/{filiaire-id}")
    public ResponseEntity<Object> findById(@PathVariable("filiaire-id") int id) {
		try {
			//Filiaire f = new  Filiaire(1,"Master Informatique - Système d'information en Entreprise","MISIE");
			return new ResponseEntity<>(filiaireRepository.findById(id), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
