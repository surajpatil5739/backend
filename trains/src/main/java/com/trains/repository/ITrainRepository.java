package com.trains.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trains.entity.Train;



public interface ITrainRepository extends JpaRepository<Train, Integer>{

	//List<Trains> findbySrcAndDest(String source_station,String destination_station);
		@Query("select u from Train u where u.train_name=:N ")
		public List<Train> getTrainName(@Param("N") String name); 
		
		@Query("select u from Train u where u.train_name=:N AND u.train_id=:id ")
		public List<Train> getTrainNameId(@Param("N") String name,@Param("id") int id); 

		@Query("select u from Train u where u.source_station=:N AND u.destination_station=:id  AND u.departure_date=:d")
		public List<Train> getTrainNameSD(@Param("N") String name,@Param("id") String id,@Param("d") Date date); 
}
