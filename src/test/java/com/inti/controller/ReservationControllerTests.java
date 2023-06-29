package com.inti.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inti.repository.IReservationRepository;

@WebMvcTest(controllers = ReservationController.class)
public class ReservationControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	IReservationRepository irr;
	
	
	@Test
	public void saveReservation() throws Exception {
		mockMvc.perform(get("/enregistrerReservation/1"))
		.andExpect(status().isOk())
		.andDo(print());
	}

}
