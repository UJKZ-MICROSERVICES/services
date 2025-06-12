package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.student.service.models.Filiaire;
import com.student.service.repositories.FiliaireRepository;

@SpringBootApplication
public class StudentServiceApplication implements CommandLineRunner{
	
	@Autowired
	private FiliaireRepository filiaireRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------errrerrrreer-----------------------------------------");
		//filiaireRepository.save(new Filiaire(1,"Master Informatique Systeme d'information en Entreprise","MISIE"));
		//filiaireRepository.save(new Filiaire(1,"Master Informatique - Système d'information en Entreprise","MISIE"));
		//filiaireRepository.save(new Filiaire(2,"Master Informatique - Sécurité Informatique","MISI"));
	}

}


