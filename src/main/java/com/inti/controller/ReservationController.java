package com.inti.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
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
		
		return "redirect:/listeHotel";
	}

}
