package com.inti.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;

@WebMvcTest(controllers = HotelController.class)
public class HotelControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IHotelRepository ihr;
	
	
	@Test
	public void saveHotel() throws Exception {
		mockMvc.perform(get("/enregistrerHotel"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void listeHotel() throws Exception {
		mockMvc.perform(get("/listeHotel"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
//	@Test
//	public void modifierHotel() throws Exception {
//				
//		mockMvc.perform(get("/modifierHotel/1").requestAttr("hotel", new Hotel("h", 3)))
//		.andExpect(status().isOk())
//		.andDo(print());
//	}
	
	@Test
	public void modifierHotelPost() throws Exception {
		mockMvc.perform(post("/modifierHotel/1").sessionAttr("hotel", new Hotel("nomH", 5)))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/listeHotel"))
		.andDo(print());
	}
	
	
	@Test
	public void deleteHotel() throws Exception {
		mockMvc.perform(get("/supprimerHotel/1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/listeHotel"))
		.andDo(print());
	}
	
	
	@Test
	public void saveHotelPost() throws Exception {
		mockMvc.perform(post("/enregistrerHotel").sessionAttr("hotel", new Hotel("h", 4)))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	
	
	
//	

}
