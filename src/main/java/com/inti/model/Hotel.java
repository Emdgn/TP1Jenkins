package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHotel;
	private String nom;
	private int nbEtoile;
	
	
	public Hotel(String nom, int nbEtoile) {
		super();
		this.nom = nom;
		this.nbEtoile = nbEtoile;
	}
	
	

}
