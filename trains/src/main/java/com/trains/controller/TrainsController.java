package com.trains.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trains.entity.Train;
import com.trains.services.TrainService;

@RestController
@RequestMapping("/train")
@CrossOrigin(origins="http://localhost:4200")
public class TrainsController {

	@Autowired
	private TrainService trainServ;
	
	
	
	@PostMapping(path="/addTrain")
	public String addTrain(@RequestBody Train train)
	{
		trainServ.addTrain(train);
		return "Train Added succesfully";
	}
	@GetMapping(path="/getTrains")
	public List<Train> getTrains()
	{
		return trainServ.getAll();
	}
	
	@GetMapping(path="/getTrainName/{name}/{id}")
	public List<Train> getTrains(@PathVariable String name , @PathVariable int id)
	{
		System.out.println(name);
		return trainServ.getTrainsId(name,id);
	}
	

	
	
	@GetMapping(path="/getTrainSD/{src}/{dest}/{date}")
	public List<Train> getTrains(@PathVariable String src , @PathVariable String dest, @PathVariable Date date)
	{
		
		return trainServ.getTrainsSD(src,dest,date);
	}
	
	@DeleteMapping(path="/cancel/{id}")
	public String cancel(@PathVariable int id)
	{
		trainServ.cancelTrain(id);
		return "Record delteed succsefully";
	}
	
	
	@PutMapping(path="/updateSeats/{count}/{class_type}")
	public void updateACSeats(@PathVariable int count,@PathVariable String class_type,@RequestBody Train train)
	{
		if(class_type.equals("AC")) 
		{
			
			trainServ.updateTrainAC(train,count);
			
			
		}
		if(class_type.equals("Sleeper")) 
		{
			
			trainServ.updateTrainSleeper(train,count);
			
			
		}
		if(class_type.equals("Seater")) 
		{
			
			trainServ.updateTrainSeater(train,count);
			
			
		}
		
	}
	
	@GetMapping("/getTrain/{id}")
	public Train getPassenger(@PathVariable int id) {
		return trainServ.getTrain(id);
	}

}
