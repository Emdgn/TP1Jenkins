package com.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.inti.model.Hotel;
import com.inti.repository.IDestinationRepository;
import com.inti.repository.IHotelRepository;

@Controller
public class DestinationController {
	
	@Autowired
	IDestinationRepository idr;
	
	@Autowired
	IHotelRepository ihr;
	
	@GetMapping("listeDestination")
	public String listeDestination(Model m) {
		m.addAttribute("listeDestination", idr.findAll());
		return "listeDestination";
	}
	
	@GetMapping("listeHotelParDestination/{idDestination}")
	public String listeHotel(Model m, @PathVariable("idDestination") int idDestination) {
		
		
		List<Hotel> ListeHotelParDestination = ihr.returnListeHotelParDestination(idDestination);
		
		
		m.addAttribute("listeHotelParDestination", ListeHotelParDestination);
		return "listeHotelParDestination";
	}
	
	
	

}
