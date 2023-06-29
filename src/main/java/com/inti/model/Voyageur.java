package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity @Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Voyageur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVoyageur;
	private String nom;
	private String prenom;
	private int age;
	private String username;
	private String mdp;
	
	@Exclude
	@OneToMany(mappedBy = "voyageur")
	private List<Reservation> listeReservation;

}
