package com.OldageHomeApp.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.OldageHomeApp.service.DTO.GuardianDTO;
import com.OldageHomeApp.service.DTO.GuardianUpdateDTO;
import com.OldageHomeApp.service.DTO.ServiceResponse;
import com.OldageHomeApp.service.entity.GuardianEntity;
import com.OldageHomeApp.service.repository.GuardianRepository;
import com.OldageHomeApp.service.repository.ResidentRepository;
import com.OldageHomeApp.service.service.GuardianService;
import com.OldageHomeApp.service.util.Constants;

@Service
public class GuardianServiceImp implements GuardianService
{
	private static Logger logger = LogManager.getLogger(GuardianServiceImp.class);

	@Autowired
	GuardianRepository guardianrepo;
	
	@Autowired
	ResidentRepository residentrepo;
	
	
	public ServiceResponse createGuardian(GuardianDTO guardiandto) {
	    try {
	        GuardianEntity guardianentity = new GuardianEntity();
	        guardianentity.setAddress(guardiandto.getAddress());
	        guardianentity.setAge(guardiandto.getAge());
	        guardianentity.setBloodgroup(guardiandto.getBloodgroup());
	        guardianentity.setEmail(guardiandto.getEmail());
	        guardianentity.setPhone(guardiandto.getPhone());
	        guardianentity.setResidentId(guardiandto.getResidentId());
	        guardianentity.setGender(guardiandto.getGender());
	        
	        guardianrepo.save(guardianentity);
	        
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);
	        
	    } 
	    catch (Exception e) 
	    {
	        System.err.println("Error occurred while creating guardian: " + e.getMessage());
	        
	        logger.error("Error : " + e.getMessage(), e);

	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to add guardian: " + e.getMessage(), null);
	    }
	}

	
	public ServiceResponse getGuardian(long id) {
	    try {
	        // Find the guardian by ID
	        GuardianEntity guardianentity = guardianrepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Guardian not found with ID: " + id));
	        
	        // Convert the entity to a DTO (if needed)
	        GuardianDTO guardiandto = new GuardianDTO();
	        guardiandto.setAddress(guardianentity.getAddress());
	        guardiandto.setAge(guardianentity.getAge());
	        guardiandto.setBloodgroup(guardianentity.getBloodgroup());
	        guardiandto.setEmail(guardianentity.getEmail());
	        guardiandto.setPhone(guardianentity.getPhone());
	        guardiandto.setResidentId(guardianentity.getResidentId());
	        guardiandto.setGender(guardianentity.getGender());
	        
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);
	    } 
	    catch (Exception e) 
	    {
	        // Log the exception and return a failure response
	        System.err.println("Error occurred while retrieving guardian: " + e.getMessage());
	        logger.error("Error : " + e.getMessage(), e);	        
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to retrieve guardian: " + e.getMessage(), null);
	    }
	}

	
	public ServiceResponse deleteGuardian(long id) {
	    try {
	        // Check if the guardian exists
	        if (!guardianrepo.existsById(id)) {
	            throw new RuntimeException("Guardian not found with ID: " + id);
	        }
	        
	        // Delete the guardian
	        guardianrepo.deleteById(id);
	        
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, "Guardian deleted successfully", null);
	    } 
	    catch (Exception e) {
	        // Log the exception and return a failure response
	        System.err.println("Error occurred while deleting guardian: " + e.getMessage());
	        logger.error("Error : " + e.getMessage(), e);	        
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to delete guardian: " + e.getMessage(), null);
	    }
	}

	
	public ServiceResponse updateGuardian(GuardianUpdateDTO guardiandto) {
	    try {
	        // Find the existing guardian by ID
	        GuardianEntity guardianentity = guardianrepo.findById(guardiandto.getId())
	                .orElseThrow(() -> new RuntimeException("Guardian not found with ID: " + guardiandto.getId()));
	        
	        // Update the existing guardian details
	        guardianentity.setAddress(guardiandto.getAddress());
	        guardianentity.setAge(guardiandto.getAge());
	        guardianentity.setBloodgroup(guardiandto.getBloodgroup());
	        guardianentity.setEmail(guardiandto.getEmail());
	        guardianentity.setPhone(guardiandto.getPhone());
	        guardianentity.setResidentId(guardiandto.getResidentId());
	        guardianentity.setGender(guardiandto.getGender());
	        
	        // Save the updated entity back to the database
	        guardianrepo.save(guardianentity);
	        
	        return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_FOUND, null);
	    } 
	    catch (Exception e) {
	    	
	        // Log the error for debugging
	        System.err.println("Error occurred while updating guardian: " + e.getMessage());
	        
	        logger.error("Error : " + e.getMessage(), e);
	        
	        // Return a failure response with the exception message
	        return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to update guardian: " + e.getMessage(), null);
	    }
	}


}
