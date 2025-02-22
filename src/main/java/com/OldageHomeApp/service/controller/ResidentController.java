package com.OldageHomeApp.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OldageHomeApp.service.DTO.ResidentDTO;
import com.OldageHomeApp.service.DTO.ResidentHealthDTO;
import com.OldageHomeApp.service.service.ResidentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/resident")
public class ResidentController 
{
	@Autowired
	ResidentService residentservice;
	
	@GetMapping("/{id}")
	ResponseEntity<?> getResidentDetails(@PathVariable Long id)
	{
		return new ResponseEntity<>(residentservice.getResident(id),HttpStatus.OK);
	}
	
	@PostMapping("/create-resident")
	ResponseEntity<?> CreateResident(@Valid @RequestBody ResidentDTO residentDTO)
	{
		return new ResponseEntity<>(residentservice.createResident(residentDTO),HttpStatus.OK);
	}
	
	@PostMapping("/add-healthdetails")
	ResponseEntity<?> CreateResidenthealthdetails(@Valid @RequestBody ResidentHealthDTO residentDTO)
	{
		return new ResponseEntity<>(residentservice.addResidentHealthDetails(residentDTO),HttpStatus.OK);
	}
	
	@PutMapping("/update-healthdetails")
	ResponseEntity<?> UpdateResidenthealthdetails(@Valid @RequestBody ResidentHealthDTO residentDTO)
	{
		return new ResponseEntity<>(residentservice.UpdateResidentHealthDetails(residentDTO),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete-resident")
	ResponseEntity<?> DeleteResident(@PathVariable Long id)
	{
		return new ResponseEntity<>(residentservice.deleteResident(id),HttpStatus.OK);
	}
	
	@GetMapping("/all-residents")
	ResponseEntity<?> getAllResidentDetails(@RequestParam("searchParam") String searchParam,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("iDisplayLength") String iDisplayLength)
	{
		System.out.println(iDisplayStart);
		System.out.println(iDisplayLength);
		return new ResponseEntity<>(residentservice.getAllResident(searchParam,0,10),HttpStatus.OK);
	}
	
	@GetMapping("/get-residents-id")
	ResponseEntity<?> getResidentIDDetails()
	{
		return new ResponseEntity<>(residentservice.getResidentIdName(),HttpStatus.OK);
	}
	

}
