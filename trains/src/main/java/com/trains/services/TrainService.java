package com.trains.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trains.repository.ITrainRepository;
import com.trains.entity.Train;


@Service
public class TrainService {

	@Autowired
	ITrainRepository trainRepo;
	
	public Train addTrain(Train train)
	{
		return trainRepo.save(train);
	}
	public List<Train> getAll()
	{
		return trainRepo.findAll();
	}

	
	public List<Train> getTrainsId(String name,int id)
	{
		return trainRepo.getTrainNameId(name,id);
	}
	public List<Train> getTrainsSD(String src,String dest,Date date)
	{
		return trainRepo.getTrainNameSD(src,dest,date);
	}
	public void cancelTrain(int id)
	{
		trainRepo.deleteById(id);
	}
	
	
	public Train updateTrainSleeper(Train train,int x)
	{
		Optional<Train> T1 = trainRepo.findById(train.getTrain_id());
		
		
			Train updatedTrain = T1.get();
			updatedTrain.setNo_of_Sleeper(train.getNo_of_Sleeper()-x);
			System.out.print(updatedTrain.getNo_of_Sleeper());
			return trainRepo.save(updatedTrain);
		
		
		
	}
	
	public Train updateTrainSeater(Train train,int x)
	{
		Optional<Train> T1 = trainRepo.findById(train.getTrain_id());
		
		
			Train updatedTrain = T1.get();
			updatedTrain.setNo_of_Seater(train.getNo_of_Seater()-x);
			System.out.print(updatedTrain.getNo_of_Seater());
			return trainRepo.save(updatedTrain);
		
		
		
	}
	
	public Train updateTrainAC(Train train,int x)
	{
		System.out.print("in ac");
		Optional<Train> T1 = trainRepo.findById(train.getTrain_id());
		
		
			Train updatedTrain = T1.get();
			updatedTrain.setNo_of_AC(train.getNo_of_AC()-x);
			System.out.print(updatedTrain.getNo_of_AC());
			return trainRepo.save(updatedTrain);
		
		
		
	}
	
	public Train getTrain(int id) {
		Optional<Train> optTrain = trainRepo.findById(id);
		return optTrain.get();
	}
}
