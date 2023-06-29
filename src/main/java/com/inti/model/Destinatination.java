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
public class Destinatination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDestination;
	private String nomDestination;
	private long longitude;
	private long latitude;
	
	@Exclude
	@OneToMany(mappedBy = "destination")
	private List<Hotel> listeHotel;

}
