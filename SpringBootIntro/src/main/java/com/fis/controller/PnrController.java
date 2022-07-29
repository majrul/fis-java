package com.fis.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fis.entity.Passenger;
import com.fis.entity.Pnr;
import com.fis.entity.Passenger.Gender;
import com.fis.entity.Passenger.Status;

//assume you are working for IRCTC/Indian Railways
//and you are responsible for developing this API
@RestController
public class PnrController {

	//http://localhost:8080/pnr-status?pnr=1234567890
	@GetMapping("/pnr-status")
	public Pnr getStatus(@RequestParam("pnr") int pnrNo) {
		//right now we will not use any database
		//in a real scenario, we will make a call to some Dao
		//for the time being, we will hardcode some data and return it
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2022, 7, 30));
		
		List<Passenger> list = new ArrayList<>();
		list.add(new Passenger("Ram", Gender.MALE, Status.RAC));
		list.add(new Passenger("Shyam", Gender.MALE, Status.CONFIRMED));
		pnr.setPassengers(list);
		
		return pnr;
	}
}
