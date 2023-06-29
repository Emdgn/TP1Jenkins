package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Hotel;
import com.inti.model.Voyageur;
import com.inti.repository.IVoyageurRepository;

@Controller
public class VoyageurController {

	@Autowired
	IVoyageurRepository ivr;
	
	@GetMapping("creerCompte")
	public String creerCompte() {
		return "creerCompte";
	}

	@PostMapping("creerCompte")
	public String creerCompte(@ModelAttribute("voyageur") Voyageur voyageur) {
		
		ivr.save(voyageur);
		
		return "creerCompte";
	}
	
	
}
