package com.inti.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Reservation;
import com.inti.repository.IReservationRepository;

@Controller
public class ReservationController {
	
	@Autowired
	IReservationRepository irr;

	@GetMapping("enregistrerReservation/{idHotel}")
	public String enregistrerReservation() {
		return "enregistrerReservation";
	}

	@PostMapping("enregistrerReservation/{idHotel}")
	public String enregistrerReservation(@RequestParam("dateReservation") LocalDate dateReservation, 
			@RequestParam("dateDepart") LocalDate dateDepart, @PathVariable("idHotel") int idHotel) {
		
		
		int nbJours = (int) ChronoUnit.DAYS.between(dateReservation, dateDepart);
		
		Reservation reservation = new Reservation(dateReservation, nbJours);
		
		irr.save(reservation);
		
		irr.insertIdHotel(idHotel, reservation.getIdVoyageur());
				
		return "redirect:/listeReservation";
	}
	
	@GetMapping("listeReservation")
	public String listeReservation(Model m) {
		m.addAttribute("listeReservation", irr.findAll());
		return "listeReservation";
	}
	
	
	@GetMapping("supprimeReservation/{idVoyageur}")
	public String supprimerReservation(@PathVariable("idVoyageur") int idVoyageur) {
		irr.delete(irr.getReferenceById(idVoyageur));
		return "redirect:/listeReservation";
	}

	@GetMapping("modifierReservation/{idVoyageur}")
	public String modifierReservation(@PathVariable("idVoyageur") int idVoyageur, Model m) {
		
		Reservation reservation = irr.getReferenceById(idVoyageur);
		m.addAttribute("reservation", reservation);
		
		
		LocalDate dateDepart = reservation.getDateReservation().plusDays(reservation.getNbJours());
		m.addAttribute("dateDepart", dateDepart);
		
		return "modifierReservation";
	}

	@PostMapping("modifierReservation/{idVoyageur}")
	public String modifierReservation(@ModelAttribute("reservation") Reservation reservation, @RequestParam("dateReservation") LocalDate dateReservation, 
			@RequestParam("dateDepart") LocalDate dateDepart) {
		
		System.out.println("réservation : " + dateReservation);
		System.out.println("départ : " + dateDepart);
		
		int nbJours = (int) ChronoUnit.DAYS.between(dateReservation, dateDepart);
		
		System.out.println("jours : " + nbJours);
				
		reservation.setNbJours(nbJours);
		
		irr.save(reservation);
		
		return "redirect:/listeReservation";
	}

}
