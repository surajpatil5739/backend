package com.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passenger.entity.Passengers;

public interface IPassengerRepository extends JpaRepository<Passengers, Integer> {

}
