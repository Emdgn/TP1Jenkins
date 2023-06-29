package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;


@Controller
public class HotelController {

	@Autowired
	IHotelRepository ihr;

	@GetMapping("enregistrerHotel")
	public String enregistrerHotel() {
		return "enregistrerHotel";
	}

	@PostMapping("enregistrerHotel")
	public String enregistrerHotel(@ModelAttribute("hotel") Hotel hotel) {
		ihr.save(hotel);
		return "enregistrerHotel";
	}

	@GetMapping("listeHotel")
	public String listeHotel(Model m) {
		m.addAttribute("listeHotel", ihr.findAll());
		return "listeHotel";
	}

	@GetMapping("supprimerHotel/{idHotel}")
	public String supprimerHotel(@PathVariable("idHotel") int idHotel) {
		ihr.delete(ihr.getReferenceById(idHotel));
		return "redirect:/listeHotel";
	}

	@GetMapping("modifierHotel/{idHotel}")
	public String modifierHotel(@PathVariable("idHotel") int idHotel, Model m) {
		m.addAttribute("hotel", ihr.getReferenceById(idHotel));
		return "modifierHotel";
	}

	@PostMapping("modifierHotel/{idHotel}")
	public String modifierHotel(@ModelAttribute("hotel") Hotel hotel) {
		ihr.save(hotel);
		return "redirect:/listeHotel";
	}

}
