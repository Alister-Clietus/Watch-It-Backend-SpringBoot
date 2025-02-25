package com.OldageHomeApp.service.serviceImp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.OldageHomeApp.service.DTO.ResidentDTO;
import com.OldageHomeApp.service.DTO.ResidentHealthDTO;
import com.OldageHomeApp.service.DTO.ResidentUpdateDTO;
import com.OldageHomeApp.service.DTO.ServiceResponse;
import com.OldageHomeApp.service.entity.ResidentEntity;
import com.OldageHomeApp.service.entity.ResidentHealthEntity;
import com.OldageHomeApp.service.entity.ResidentPdfFilesEntity;
import com.OldageHomeApp.service.repository.GuardianRepository;
import com.OldageHomeApp.service.repository.ResidentHealthRepositoy;
import com.OldageHomeApp.service.repository.ResidentPdfFilesRepo;
import com.OldageHomeApp.service.repository.ResidentRepository;
import com.OldageHomeApp.service.repository.specification.InmatesSpecification;
import com.OldageHomeApp.service.service.ResidentService;
import com.OldageHomeApp.service.util.Constants;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResidentServiceImp implements ResidentService
{
	private static Logger logger = LogManager.getLogger(ResidentServiceImp.class);

	@Autowired
	GuardianRepository guardianrepo;
	
	@Autowired
	ResidentRepository residentrepo;
	
	@Autowired
	ResidentHealthRepositoy residentHealthRepo;
	
	@Autowired
	ResidentPdfFilesRepo residentpdffilesrepo;
	
	public ServiceResponse createResident(ResidentDTO residentdto) 
	{
	    try {
	        // Validate input (this is usually handled by @Valid annotations in the controller layer)
	        if (residentdto == null) {
	            throw new IllegalArgumentException("Resident details cannot be null");
	        }

	        // Create a new ResidentEntity object
	        ResidentPdfFilesEntity residentpdffilesentity=new ResidentPdfFilesEntity();
	        ResidentEntity residentEntity = new ResidentEntity();
	        residentEntity.setFirstName(residentdto.getFirstName());
	        residentEntity.setLastName(residentdto.getLastName());
	        residentEntity.setAdhaarNumber(residentdto.getAdhaarNumber());
	        residentEntity.setPanId(residentdto.getPanId());
	        residentEntity.setNo_of_childrens(residentdto.getNo_of_childrens());
	        residentEntity.setNativeplace(residentdto.getNativeplace());
	        residentEntity.setGuardian(residentdto.getGuardian());
	        residentEntity.setBirthPlace(residentdto.getBirthPlace());
	        residentEntity.setDateOfBirth(residentdto.getDateOfBirth());
	        residentEntity.setGender(residentdto.getGender());
	        residentEntity.setAddress(residentdto.getAddress());
	        residentEntity.setBloodGroup(residentdto.getBloodGroup());
	        residentEntity.setWeight(residentdto.getWeight());
	        residentEntity.setHeight(residentdto.getHeight());
	        residentEntity.setJoinedDate(residentdto.getJoineddate());
	        residentpdffilesentity.setName(residentdto.getFirstName());
	        ResidentHealthEntity residenthealthentity = new ResidentHealthEntity();
	        residenthealthentity.setFirstName(residentdto.getFirstName());
	        residenthealthentity.setLastName(residentdto.getLastName());
	        residentHealthRepo.save(residenthealthentity);
	        residentpdffilesrepo.save(residentpdffilesentity);
	        // Save the resident entity to the database
	        residentrepo.save(residentEntity);

	        // Create a success response
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);
	    } 
	    catch (Exception e) 
	    {
	        // Log the exception
	        System.err.println("Error occurred while creating resident: " + e.getMessage());
	        
	        logger.error("Error : " + e.getMessage(), e);

	        // Return a failure response
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, Constants.USERLOG.USER_ADDED, null);
	    }
	}

	public ServiceResponse getResident(long id) 
	{
	    try {
	        // Find the resident by ID
	        ResidentEntity residentEntity = residentrepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + id));

	        // Convert the entity to a DTO
	        ResidentDTO residentDTO = new ResidentDTO();
//	        residentDTO.setId(residentEntity.getId());
	        residentDTO.setFirstName(residentEntity.getFirstName());
	        residentDTO.setLastName(residentEntity.getLastName());
	        residentDTO.setDateOfBirth(residentEntity.getDateOfBirth());
	        residentDTO.setGender(residentEntity.getGender());
	        residentDTO.setAddress(residentEntity.getAddress());
	        residentDTO.setJoineddate(residentEntity.getJoinedDate());

	        // Return a success response with the resident details
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);
	    } 
	    catch (Exception e) 
	    {
	        // Log the exception
	        System.err.println("Error occurred while retrieving resident: " + e.getMessage());
	        
	        logger.error("Error : " + e.getMessage(), e);


	        // Return a failure response with the error message
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to retrieve resident: " + e.getMessage(), null);
	    }
	}

	public ServiceResponse deleteResident(long id) 
	{
	    try 
	    {
	        // Check if the resident exists
	        ResidentEntity residentEntity = residentrepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + id));

	        // Delete the resident
	        residentrepo.delete(residentEntity);

	        // Return a success response
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, "Resident deleted successfully", null);
	    } 
	    catch (Exception e) 
	    {
	        // Log the exception
	        System.err.println("Error occurred while deleting resident: " + e.getMessage());
	        e.printStackTrace();

	        // Return a failure response with the error message
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to delete resident: " + e.getMessage(), null);
	    }
	}

	public ServiceResponse updateResident(ResidentUpdateDTO residentdto) {
	    try {
	        // Find the existing resident by ID
	        ResidentEntity residentEntity = residentrepo.findById(residentdto.getId())
	                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + residentdto.getId()));

	        // Update the resident details
	        residentEntity.setFirstName(residentdto.getFirstName());
	        residentEntity.setLastName(residentdto.getLastName());
	        residentEntity.setDateOfBirth(residentdto.getDateOfBirth());
	        residentEntity.setGender(residentdto.getGender());
	        residentEntity.setAddress(residentdto.getAddress());
	        residentEntity.setJoinedDate(residentdto.getJoineddate());

	        // Save the updated entity to the database
	        residentrepo.save(residentEntity);

	        // Return a success response
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, "Resident updated successfully", null);
	    } 
	    catch (Exception e) 
	    {
	        // Log the exception
	        System.err.println("Error occurred while updating resident: " + e.getMessage());
	        
	        logger.error("Error : " + e.getMessage(), e);

	        // Return a failure response with the error message
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to update resident: " + e.getMessage(), null);
	    }
	}

	public ServiceResponse addResidentHealthDetails(ResidentHealthDTO residenthealthdto) {
	    try {
	        // Check if the resident exists in the ResidentEntity repository
	        residentrepo.findById(residenthealthdto.getId())
	                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + residenthealthdto.getId()));

	        // Map DTO to Entity
	        ResidentHealthEntity residentHealthEntity = new ResidentHealthEntity();
	        residentHealthEntity.setId(residenthealthdto.getId());
	        residentHealthEntity.setBloodPressure(residenthealthdto.getBloodPressure());
	        residentHealthEntity.setSugarLevel(residenthealthdto.getSugarLevel());
	        residentHealthEntity.setCholesterol(residenthealthdto.getCholesterol());
	        residentHealthEntity.setIsAbleToWalk(residenthealthdto.getIsAbleToWalk());
	        residentHealthEntity.setAppointmentDate(residenthealthdto.getAppointmentDate());
	        residentHealthEntity.setRecordedAt(residenthealthdto.getRecordedAt());

	        // Save health details in the database
	        residentHealthRepo.save(residentHealthEntity);

	        // Return a success response
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, "Resident health details added successfully", null);
	    } catch (Exception e) {
	        // Log the exception
	        System.err.println("Error occurred while adding resident health details: " + e.getMessage());
	        logger.error("Error : " + e.getMessage(), e);

	        // Return a failure response with the error message
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to add resident health details: " + e.getMessage(), null);
	    }
	}


	public ServiceResponse UpdateResidentHealthDetails(ResidentHealthDTO residenthealthdto) {
	    try {
	        // Check if the resident exists by ID in the ResidentEntity repository
	    	residentHealthRepo.findById(residenthealthdto.getId())
	                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + residenthealthdto.getId()));

	        // Check if the resident's health record exists in the ResidentHealthEntity repository
	        ResidentHealthEntity residentHealthEntity = residentHealthRepo.findById(residenthealthdto.getId())
	                .orElseThrow(() -> new RuntimeException("Health record not found for Resident ID: " + residenthealthdto.getId()));

	        // Update the health details
	        residentHealthEntity.setBloodPressure(residenthealthdto.getBloodPressure());
	        residentHealthEntity.setSugarLevel(residenthealthdto.getSugarLevel());
	        residentHealthEntity.setCholesterol(residenthealthdto.getCholesterol());
	        residentHealthEntity.setIsAbleToWalk(residenthealthdto.getIsAbleToWalk());
	        residentHealthEntity.setAppointmentDate(residenthealthdto.getAppointmentDate());
	        residentHealthEntity.setRecordedAt(residenthealthdto.getRecordedAt());

	        // Save the updated health record to the database
	        residentHealthRepo.save(residentHealthEntity);

	        // Return a success response
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, "Resident health details updated successfully", null);
	    } 
	    catch (Exception e) 
	    {
	        // Log the exception
	        System.err.println("Error occurred while updating resident health details: " + e.getMessage());
	        e.printStackTrace();

	        // Return a failure response with the error message
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to update resident health details: " + e.getMessage(), null);
	    }
	}
	

	
	public JSONObject getAllResident(String searchParam,int start,int pageSize)
	{        
		List<JSONObject> residentDetails = new ArrayList<>();
		JSONObject result = new JSONObject();
	    try {
	      Pageable pageable = PageRequest.of(start / pageSize, pageSize);
	      Specification<ResidentEntity> spec = InmatesSpecification.getno_of_childrensSpec(searchParam);
	        Page<ResidentEntity> residents = residentrepo.findAll(spec, pageable);
	      JSONArray array = new JSONArray();
//	      JSONArray countByStatus = countByStatus(spec);
	      for (ResidentEntity resident : residents) 
	      {
	        JSONObject obj = new JSONObject();
	        obj.put("id", resident.getId());
	        obj.put("firstName", resident.getFirstName());
	        obj.put("lastName", resident.getLastName());
	        obj.put("adhaarNumber", resident.getAdhaarNumber());
	        obj.put("panId", resident.getPanId());
	        obj.put("no_of_childrens", resident.getNo_of_childrens());
	        obj.put("nativePlace", resident.getNativeplace());
	        obj.put("guardian", resident.getGuardian());
	        obj.put("birthPlace", resident.getBirthPlace());
	        obj.put("dateOfBirth", resident.getDateOfBirth());
	        obj.put("gender", resident.getGender());
	        obj.put("address", resident.getAddress());
	        obj.put("bloodGroup", resident.getBloodGroup());
	        obj.put("weight", resident.getWeight());
	        obj.put("height", resident.getHeight());
	        obj.put("joinedDate", resident.getJoinedDate());
	        array.add(obj);
	      }
	      result.put("aaData", array);
	      result.put("iTotalDisplayRecords", residentrepo.findAll().size());
	      result.put("iTotalRecords", residentrepo.findAll().size());
//	      result.put("countByStatus", countByStatus);
	    } catch (Exception e) {
	      result.put("aaData", null);
	      logger.error("Error:" + e.getMessage(), e);
	      return result;
	    }
	    return result;
	}
	
	public JSONObject getResidentIdName()
	{        
		List<JSONObject> residentDetails = new ArrayList<>();
		JSONObject result = new JSONObject();
	    try {
	        List<ResidentHealthEntity> residents = residentHealthRepo.findAll();
	      JSONArray array = new JSONArray();
//	      JSONArray countByStatus = countByStatus(spec);
	      for (ResidentHealthEntity resident : residents) 
	      {
	        JSONObject obj = new JSONObject();
	        obj.put("id", resident.getId());
	        obj.put("firstName", resident.getFirstName());
	        obj.put("lastName", resident.getLastName());
	        obj.put("bloodPressure", resident.getBloodPressure());
	        obj.put("sugarLevel", resident.getSugarLevel());
	        obj.put("cholesterol", resident.getCholesterol());
	        obj.put("isAbleToWalk", resident.getIsAbleToWalk());
	        obj.put("appointmentDate", resident.getAppointmentDate());
	        obj.put("recordedAt", resident.getRecordedAt());
	        array.add(obj);
	      }
	      result.put("aaData", array);
	      result.put("iTotalDisplayRecords", residentrepo.findAll().size());
	      result.put("iTotalRecords", residentrepo.findAll().size());
//	      result.put("countByStatus", countByStatus);
	    } catch (Exception e) {
	      result.put("aaData", null);
	      logger.error("Error:" + e.getMessage(), e);
	      return result;
	    }
	    return result;
	}
	
	


	
	




}
