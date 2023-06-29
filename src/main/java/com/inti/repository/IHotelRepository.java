package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.model.Hotel;

import jakarta.transaction.Transactional;

@Repository @Transactional
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
	
	@Query(value = "select id_destination from destinatination where nom_destination = :ville", nativeQuery = true)
	int returnIdVille(@Param("ville") String ville);
	
	@Modifying
	@Query(value = "update hotel set id_destination = :idDestination where id_hotel= :idHotel", nativeQuery = true)
	void insertIdDestination(@Param("idHotel") int idHotel, @Param("idDestination") int idDestination);

	@Query(value = "select * from Hotel where id_Destination = :idDestination", nativeQuery = true)
//	@Query(value = "select new Hotel(idHotel, nbEtoile, nom) from Hotel where idDestination = :idDestination", nativeQuery = false)
	List<Hotel> returnListeHotelParDestination(@Param("idDestination") int idDestination);
	
}
