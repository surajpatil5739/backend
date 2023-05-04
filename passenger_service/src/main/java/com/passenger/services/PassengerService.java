package com.passenger.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passenger.entity.Passengers;
import com.passenger.repository.IPassengerRepository;

@Service
public class PassengerService {

	@Autowired
	private IPassengerRepository passRepository;
	
	public int registerPassenger(Passengers pass) {
		passRepository.save(pass);
		return pass.getPassenger_id();
	}
	
	public void deletePassenger(int id) {
		passRepository.deleteById(id);
	}
	
	public Passengers getPassenger(int id) {
		Optional<Passengers> optPass = passRepository.findById(id);
		return optPass.get();
	}
}
