package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString.Exclude;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVoyageur;
	@Column(nullable = false)
	@NonNull
	private LocalDate dateReservation;
	private int nbJours;
	
	@Exclude
	@ManyToOne
	@JoinColumn(name = "idHotel")
	private Hotel hotel;
	
	@Exclude
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Voyageur voyageur;
	
	
	public Reservation(@NonNull LocalDate dateReservation, int nbJours) {
		super();
		this.dateReservation = dateReservation;
		this.nbJours = nbJours;
	}
	
	
}
