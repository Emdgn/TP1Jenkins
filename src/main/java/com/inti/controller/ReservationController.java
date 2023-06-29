package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Reservation;
import com.inti.repository.IReservationRepository;

@Controller
public class ReservationController {
	
	@Autowired
	IReservationRepository irr;

	@GetMapping("enregistrerReservation")
	public String enregistrerReservation() {
		return "enregistrerReservation";
	}

	@PostMapping("enregistrerReservation")
	public String enregistrerReservation(@ModelAttribute("reservation") Reservation reservation) {
		irr.save(reservation);
		return "enregistrerReservation";
	}

}
