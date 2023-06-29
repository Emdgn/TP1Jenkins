package com.inti.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Hotel;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class HotelRepositoryTests {

	@Autowired
	IHotelRepository ihr;
	
	
	@Test
	public void saveHotel() {
		Hotel hotel = new Hotel("nomH", 3);
		
		Hotel hotelSaved = ihr.save(hotel);
		
		assertThat(hotelSaved).isNotNull();
		assertThat(hotelSaved.getIdHotel()).isGreaterThan(0);
		
	}
	
	@Test
	public void saveHotelWithoutAllArgs() {
		Hotel hotel = new Hotel();
		hotel.setNom("Hotel1");
		
		Hotel hotelSaved = ihr.save(hotel);
		
		assertThat(hotelSaved).isNotNull();
		assertThat(hotelSaved.getIdHotel()).isGreaterThan(0);
		assertThat(hotelSaved.getNom()).isEqualTo("Hotel1");
		assertThat(hotelSaved.getNbEtoile()).isNull();
	}
	
	@Test
	public void saveHotelNull() {
		
		Assertions.assertThrows(Exception.class, () -> ihr.save(null));
	}
	
	
	@Test
	public void modifieHotel() {
		Hotel hotel = new Hotel("nom", 5);
		ihr.save(hotel);
		
		hotel.setNbEtoile(6);
		
		assertThat(hotel.getNbEtoile()).isEqualTo(6);
		assertThat(hotel.getNom()).isEqualTo("nom");
	}
	
	@Test
	public void midifieHotelNull() {
		Hotel hotel = null;
		
		Assertions.assertThrows(Exception.class, () -> hotel.setNom("nh"));
	}
	
	
	@Test
	public void supprimerHotel() {
		Hotel hotel = new Hotel();
		ihr.save(hotel);
		
		ihr.delete(hotel);
		
		Assertions.assertThrows(Exception.class, () -> ihr.getReferenceById(hotel.getIdHotel()));
	}
	
	@Test
	public void afficherHotel() {
		
		Hotel hotel = new Hotel("nom", 3);
		ihr.save(hotel);
		
		assertThat(ihr.getReferenceById(hotel.getIdHotel())).isEqualTo(hotel);
	}
	
//	@Test
//	public void afficherListehotel() {
//		Hotel h1 = new Hotel();
//		Hotel h2 = new Hotel();
//		Hotel h3 = new Hotel();
//		
//		ihr.save(h1);
//		ihr.save(h2);
//		ihr.save(h3);
//		
//		List<Hotel> listeHotel = List.of(h1, h2, h3);
//		
//		assertThat(ihr.findAll()).isEqualTo(listeHotel);
//		assertThat(ihr.findAll().get(0)).isEqualTo(h1);
//	}
	
	
}
