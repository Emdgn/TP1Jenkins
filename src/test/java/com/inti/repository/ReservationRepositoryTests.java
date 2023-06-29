package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Reservation;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ReservationRepositoryTests {
	
	@Autowired
	IReservationRepository irr;
	
	
	@Test
	public void saveReservation() {
		Reservation reservation = new Reservation(LocalDate.of(2023, 01, 01), 2);
		
		Reservation reservationSaved = irr.save(reservation);
		
		assertThat(reservationSaved).isNotNull();
		assertThat(reservationSaved.getIdVoyageur()).isGreaterThan(0);
	}

}
