package com.inti.repository;

import java.time.LocalDate;

import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Reservation;

import jakarta.transaction.Transactional;

@Repository @Transactional
public interface IReservationRepository extends JpaRepository<Reservation, Integer> {

	@Modifying
	@Query(value = "update reservation set id_hotel = :idHotel where id_voyageur = :idVoyageur", nativeQuery = true)
	void insertIdHotel(@Param("idHotel") int idHotel, @Param("idVoyageur") int idVoyageur);
}
