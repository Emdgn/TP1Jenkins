package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Destinatination;
import com.inti.model.Hotel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IDestinationRepository extends JpaRepository<Destinatination, Integer> {

//	@Query(value = "select new Hotel(idHotel, nbEtoile, nom) from Hotel where idDestination = :idDestination", nativeQuery = false)
//	List<Hotel> returnListeHotelParDestination(@Param("idDestination") int idDestination);
//	

}
