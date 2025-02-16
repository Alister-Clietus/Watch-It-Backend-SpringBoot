package com.OldageHomeApp.service.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.OldageHomeApp.service.DTO.DoctorAppointmentDTO;
import com.OldageHomeApp.service.DTO.DoctorDTO;
import com.OldageHomeApp.service.DTO.GuardianDTO;
import com.OldageHomeApp.service.DTO.GuardianUpdateDTO;
import com.OldageHomeApp.service.DTO.ResidentPdfFiles;
import com.OldageHomeApp.service.service.GuardianService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/guardian")
public class GuardianController {

	@Autowired
	GuardianService guardianservice;

	@PostMapping("/create-guardian")
	ResponseEntity<?> createGuardian(@Valid @RequestBody GuardianDTO guardianDTO) {

		return new ResponseEntity<>(guardianservice.createGuardian(guardianDTO), HttpStatus.OK);
	}

	@PostMapping("/update-guardian")
	ResponseEntity<?> updateGuardian(@Valid @RequestBody GuardianUpdateDTO guardianDTO) {
		return new ResponseEntity<>(guardianservice.updateGuardian(guardianDTO), HttpStatus.OK);
	}

	@PostMapping("/delete-guardian")
	ResponseEntity<?> deleteGuardian(@PathVariable Long id) {
		return new ResponseEntity<>(guardianservice.deleteGuardian(id), HttpStatus.OK);
	}

	@GetMapping("/get-guardian")
	ResponseEntity<?> getGuardian(@PathVariable Long id) {
		return new ResponseEntity<>(guardianservice.getGuardian(id), HttpStatus.OK);
	}

	// Doctor Controller APIS

	@PostMapping("/create-doctor")
	ResponseEntity<?> createDoctor(@Valid @RequestBody DoctorDTO doctordto) {
		return new ResponseEntity<>(guardianservice.createDoctor(doctordto), HttpStatus.OK);
	}

	@PostMapping("/doctor-appointment")
	ResponseEntity<?> doctorAppointment(@Valid @RequestBody DoctorAppointmentDTO doctordto) {
		return new ResponseEntity<>(guardianservice.doctorAppointment(doctordto), HttpStatus.OK);
	}

	@GetMapping("/getall-guardian/search")
	ResponseEntity<?> getAllGuardian(@RequestParam("searchParam") String searchParam,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("iDisplayLength") String iDisplayLength) {
		System.out.println(searchParam);
		System.out.println(iDisplayStart);
		System.out.println(iDisplayLength);
		return new ResponseEntity<>(guardianservice.getAllGuardian(searchParam, Integer.parseInt(iDisplayStart),
				Integer.parseInt(iDisplayLength)), HttpStatus.OK);
	}

	@GetMapping("/getall-doctors/search")
	ResponseEntity<?> getAllDoctor(@RequestParam("searchParam") String searchParam,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("iDisplayLength") String iDisplayLength) {
		System.out.println(searchParam);
		System.out.println(iDisplayStart);
		System.out.println(iDisplayLength);
		return new ResponseEntity<>(guardianservice.getAllDoctor(searchParam, Integer.parseInt(iDisplayStart),
				Integer.parseInt(iDisplayLength)), HttpStatus.OK);
	}

	@GetMapping("/getall-doctors-appointment/search")
	ResponseEntity<?> getAllDoctorAppointment(@RequestParam("searchParam") String searchParam,
			@RequestParam("iDisplayStart") String iDisplayStart,
			@RequestParam("iDisplayLength") String iDisplayLength) {
		System.out.println(searchParam);
		System.out.println(iDisplayStart);
		System.out.println(iDisplayLength);
		return new ResponseEntity<>(guardianservice.getAllDoctorAppointment(searchParam,
				Integer.parseInt(iDisplayStart), Integer.parseInt(iDisplayLength)), HttpStatus.OK);
	}

	@PostMapping("/file/upload")
	public ResponseEntity<?> uploadReport(@Valid @ModelAttribute ResidentPdfFiles dto, BindingResult result) {
	    if (result.hasErrors()) 
	    {
	        return ResponseEntity.badRequest().body("Validation error: " + result.getFieldError().getDefaultMessage());
	    }

	    try 
	    {
	        MultipartFile file1 = dto.getFullBodyTestResult();
	        MultipartFile file2 = dto.getBloodResult();
	        MultipartFile file3 = dto.getDietPlan();
        	System.out.println("checking file is there or not");
        	if ((file1 != null && !file1.isEmpty()) ||
        		    (file2 != null && !file2.isEmpty()) ||
        		    (file3 != null && !file3.isEmpty()))	        {
	        	System.out.println(dto.getName());
	        	
	        	
	    		return new ResponseEntity<>(guardianservice.uploadResidentsMedicalReport(dto),HttpStatus.OK);
	        } 
	        else 
	        {
	            
	        	return ResponseEntity.badRequest().body("No file provided.");
	        }
	    } catch (Exception e) 
	    {
	        return ResponseEntity.internalServerError().body("Error saving file: " + e.getMessage());
	    }
	}
	
	@GetMapping("/get-inpatients/pdf")
	ResponseEntity<?> getAllPatiennsPdfFiles() 
	{
		return new ResponseEntity<>(guardianservice.getAllPatiennsPdfFiles(), HttpStatus.OK);
	}
	


}
