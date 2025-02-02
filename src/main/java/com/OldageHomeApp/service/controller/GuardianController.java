package com.OldageHomeApp.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OldageHomeApp.service.DTO.GuardianDTO;
import com.OldageHomeApp.service.DTO.GuardianUpdateDTO;
import com.OldageHomeApp.service.service.GuardianService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/guardian")
public class GuardianController 
{
	
	@Autowired
	GuardianService guardianservice;
	
	
	@PostMapping("/create-guardian")
	ResponseEntity<?> createGuardian(@Valid @RequestBody GuardianDTO guardianDTO)
	{
		
		return new ResponseEntity<>(guardianservice.createGuardian(guardianDTO),HttpStatus.OK);
	}
	
	@PostMapping("/update-guardian")
	ResponseEntity<?> updateGuardian(@Valid @RequestBody GuardianUpdateDTO guardianDTO)
	{
		return new ResponseEntity<>(guardianservice.updateGuardian(guardianDTO),HttpStatus.OK);
	}
	
	@PostMapping("/delete-guardian")
	ResponseEntity<?> deleteGuardian(@PathVariable Long id)
	{
		return new ResponseEntity<>(guardianservice.deleteGuardian(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/get-guardian")
	ResponseEntity<?> getGuardian(@PathVariable Long id)
	{
		return new ResponseEntity<>(guardianservice.getGuardian(id),HttpStatus.OK);
	}


}
