package com.OldageHomeApp.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.OldageHomeApp.service.DTO.AdminDTO;
import com.OldageHomeApp.service.DTO.DoctorAppointmentDTO;
import com.OldageHomeApp.service.DTO.DoctorDTO;
import com.OldageHomeApp.service.DTO.GuardianDTO;
import com.OldageHomeApp.service.DTO.GuardianUpdateDTO;
import com.OldageHomeApp.service.DTO.LoginDTO;
import com.OldageHomeApp.service.DTO.ResidentPdfFiles;
import com.OldageHomeApp.service.DTO.ServiceResponse;
import com.OldageHomeApp.service.entity.AdminEntity;
import com.OldageHomeApp.service.entity.DoctorAppointmentEntity;
import com.OldageHomeApp.service.entity.DoctorEntity;
import com.OldageHomeApp.service.entity.GuardianEntity;
import com.OldageHomeApp.service.entity.LoginEntity;
import com.OldageHomeApp.service.entity.ResidentPdfFilesEntity;
import com.OldageHomeApp.service.repository.AdminRepo;
import com.OldageHomeApp.service.repository.DoctorAppointmentRepo;
import com.OldageHomeApp.service.repository.DoctorRepositor;
import com.OldageHomeApp.service.repository.GuardianRepository;
import com.OldageHomeApp.service.repository.LoginRepo;
import com.OldageHomeApp.service.repository.ResidentPdfFilesRepo;
import com.OldageHomeApp.service.repository.ResidentRepository;
import com.OldageHomeApp.service.repository.specification.AdminSpecification;
import com.OldageHomeApp.service.repository.specification.DoctorAppointmentSpecification;
import com.OldageHomeApp.service.repository.specification.DoctorSpecification;
import com.OldageHomeApp.service.repository.specification.GuardianSpecification;
import com.OldageHomeApp.service.service.GuardianService;
import com.OldageHomeApp.service.util.Constants;

@Service
public class GuardianServiceImp implements GuardianService {
	private static Logger logger = LogManager.getLogger(GuardianServiceImp.class);

	@Autowired
	GuardianRepository guardianrepo;
	
	@Autowired
	AdminRepo adminrepo;

	@Autowired
	ResidentRepository residentrepo;

	@Autowired
	DoctorRepositor doctorrepo;

	@Autowired
	DoctorAppointmentRepo doctorappointmentrepo;
	
	@Autowired
	ResidentPdfFilesRepo residentpdffilesrepo;
	
	@Autowired
	LoginRepo loginrepo;

	public ServiceResponse createGuardian(GuardianDTO guardiandto) {

		try {
			GuardianEntity guardianentity = new GuardianEntity();
			LoginEntity loginentity =new LoginEntity();
			loginentity.setEmail(guardiandto.getEmail());
			loginentity.setPassword(guardiandto.getPassword());
			loginentity.setRole(guardiandto.getRole());
			loginrepo.save(loginentity);
			guardianentity.setAddress(guardiandto.getAddress());
			guardianentity.setAge(guardiandto.getAge());
			guardianentity.setBloodgroup(guardiandto.getBloodgroup());
			guardianentity.setEmail(guardiandto.getEmail());
			guardianentity.setPhone(guardiandto.getPhone());
			guardianentity.setGender(guardiandto.getGender());
			guardianentity.setPhone(guardiandto.getPhone());
			guardianentity.setFirstName(guardiandto.getFirstName());
			guardianentity.setLastName(guardiandto.getLastName());
			guardianentity.setAdhaarNumber(guardiandto.getAdhaarNumber());
			guardianentity.setPanId(guardiandto.getPanId());
			guardianentity.setNativeplace(guardiandto.getNativeplace());
			guardianentity.setJoinedDate(guardiandto.getJoineddate());

			guardianrepo.save(guardianentity);
			return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);

		} catch (Exception e) {
			System.err.println("Error occurred while creating guardian: " + e.getMessage());

			logger.error("Error : " + e.getMessage(), e);

			return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to add guardian: " + e.getMessage(),
					null);
		}
	}
	
	public ServiceResponse createAdmin(AdminDTO guardiandto)
	{
		try {
			AdminEntity guardianentity = new AdminEntity();
			LoginEntity loginentity =new LoginEntity();
			loginentity.setEmail(guardiandto.getEmail());
			loginentity.setPassword(guardiandto.getPassword());
			loginentity.setRole(guardiandto.getRole());
			loginrepo.save(loginentity);
			
			guardianentity.setAddress(guardiandto.getAddress());
			guardianentity.setAge(guardiandto.getAge());
			guardianentity.setBloodgroup(guardiandto.getBloodgroup());
			guardianentity.setEmail(guardiandto.getEmail());
			guardianentity.setPhone(guardiandto.getPhone());
			guardianentity.setGender(guardiandto.getGender());
			guardianentity.setPhone(guardiandto.getPhone());
			guardianentity.setFirstName(guardiandto.getFirstName());
			guardianentity.setLastName(guardiandto.getLastName());
			guardianentity.setAdhaarNumber(guardiandto.getAdhaarNumber());
			guardianentity.setPanId(guardiandto.getPanId());
			guardianentity.setNativeplace(guardiandto.getNativeplace());
			guardianentity.setJoinedDate(guardiandto.getJoineddate());

			adminrepo.save(guardianentity);
			return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);

		} catch (Exception e) {
			System.err.println("Error occurred while creating guardian: " + e.getMessage());

			logger.error("Error : " + e.getMessage(), e);

			return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to add guardian: " + e.getMessage(),
					null);
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
			guardiandto.setGender(guardianentity.getGender());

			return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);
		} catch (Exception e) {
			// Log the exception and return a failure response
			System.err.println("Error occurred while retrieving guardian: " + e.getMessage());
			logger.error("Error : " + e.getMessage(), e);
			return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to retrieve guardian: " + e.getMessage(),
					null);
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
		} catch (Exception e) {
			// Log the exception and return a failure response
			System.err.println("Error occurred while deleting guardian: " + e.getMessage());
			logger.error("Error : " + e.getMessage(), e);
			return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to delete guardian: " + e.getMessage(),
					null);
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
			guardianentity.setGender(guardiandto.getGender());

			// Save the updated entity back to the database
			guardianrepo.save(guardianentity);

			return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_FOUND, null);
		} catch (Exception e) {

			// Log the error for debugging
			System.err.println("Error occurred while updating guardian: " + e.getMessage());

			logger.error("Error : " + e.getMessage(), e);

			// Return a failure response with the exception message
			return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to update guardian: " + e.getMessage(),
					null);
		}
	}

	public ServiceResponse createDoctor(DoctorDTO doctordto) {
		try {
			// Validate input (this is usually handled by @Valid annotations in the
			// controller layer)
			if (doctordto == null) {
				throw new IllegalArgumentException("Doctor details cannot be null");
			}
			// Create a new ResidentEntity object
			DoctorEntity doctorentity = new DoctorEntity();
			LoginEntity loginentity =new LoginEntity();
			loginentity.setEmail(doctordto.getEmail());
			loginentity.setPassword(doctordto.getPassword());
			loginentity.setRole(doctordto.getRole());
			loginrepo.save(loginentity);
			System.out.println("Login Details Saved");
			doctorentity.setAadharNumber(doctordto.getAadharNumber());
			doctorentity.setAddress(doctordto.getAddress());
			doctorentity.setEmail(doctordto.getEmail());
			doctorentity.setHospitalName(doctordto.getHospitalName());
			doctorentity.setName(doctordto.getName());
			doctorentity.setPhoneNumber(doctordto.getPhoneNumber());
			doctorentity.setSpecialization(doctordto.getSpecialization());

			// Save the resident entity to the database
			doctorrepo.save(doctorentity);

			// Create a success response
			return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error occurred while creating resident: " + e.getMessage());

			logger.error("Error : " + e.getMessage(), e);

			// Return a failure response
			return new ServiceResponse(Constants.MESSAGE_STATUS.fail, Constants.USERLOG.USER_ADDED, null);
		}
	}

	public ServiceResponse doctorAppointment(DoctorAppointmentDTO doctordto) {

		try {
			// Validate input (this is usually handled by @Valid annotations in the
			// controller layer)
			if (doctordto == null) {
				throw new IllegalArgumentException("Doctor details cannot be null");
			}
			// Create a new ResidentEntity object
			DoctorAppointmentEntity doctorentity = new DoctorAppointmentEntity();

			doctorentity.setAppointmentDate(doctordto.getAppointmentDDate());
			doctorentity.setAppointmentTime(doctordto.getAppointmentTime());
			doctorentity.setPatientName(doctordto.getPatientName());
			doctorentity.setDoctorName(doctordto.getDoctorName());
			// Save the resident entity to the database
			doctorappointmentrepo.save(doctorentity);

			// Create a success response
			return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);
		} catch (Exception e) {
			// Log the exception
			System.err.println("Error occurred while creating resident: " + e.getMessage());

			logger.error("Error : " + e.getMessage(), e);

			// Return a failure response
			return new ServiceResponse(Constants.MESSAGE_STATUS.fail, Constants.USERLOG.USER_ADDED, null);
		}

	}

	public JSONObject getAllDoctor(String searchParam, int start, int pageSize) {
		JSONObject result = new JSONObject();
		try {
			Pageable pageable = PageRequest.of(start / pageSize, pageSize);
			Specification<DoctorEntity> spec = DoctorSpecification.getQuestionSpec(searchParam);
			Page<DoctorEntity> usersList = doctorrepo.findAll(spec, pageable);
			JSONArray array = new JSONArray();
//	      JSONArray countByStatus = countByStatus(spec);
			for (DoctorEntity doctor : usersList) {
				JSONObject obj = new JSONObject();
				obj.put("id", doctor.getId());
				obj.put("name", doctor.getName());
				obj.put("phoneNumber", doctor.getPhoneNumber());
				obj.put("aadharNumber", doctor.getAadharNumber());
				obj.put("email", doctor.getEmail());
				obj.put("specialization", doctor.getSpecialization());
				obj.put("address", doctor.getAddress());
				obj.put("hospitalName", doctor.getHospitalName());
				array.add(obj);
			}
			result.put("aaData", array);
			result.put("iTotalDisplayRecords", doctorrepo.findAll().size());
			result.put("iTotalRecords", doctorrepo.findAll().size());
//	      result.put("countByStatus", countByStatus);
		} catch (Exception e) {
			result.put("aaData", null);
			logger.error("Error:" + e.getMessage(), e);
			return result;
		}
		return result;
	}

	public JSONObject getAllGuardian(String searchParam, int start, int pageSize) {
		List<JSONObject> guardianDetails = new ArrayList<>();
		System.out.println("in to gell all guadian");
		JSONObject result = new JSONObject();
		try {

			Pageable pageable = PageRequest.of(start / pageSize, pageSize);
			Specification<GuardianEntity> spec = GuardianSpecification.getemailSpec(searchParam);
			Page<GuardianEntity> usersPage = guardianrepo.findAll(spec, pageable);
			JSONArray array = new JSONArray();
//	      JSONArray countByStatus = countByStatus(spec);
			System.out.println("before for loop");

			for (GuardianEntity guardian : usersPage) {
				JSONObject obj = new JSONObject();
				System.out.println(guardian.getFirstName());
				obj.put("firstName", guardian.getFirstName());
				obj.put("lastName", guardian.getLastName());
				obj.put("age", guardian.getAge());
				obj.put("address", guardian.getAddress());
				obj.put("bloodGroup", guardian.getBloodgroup());
				obj.put("gender", guardian.getGender());
				obj.put("email", guardian.getEmail());
				obj.put("phone", guardian.getPhone());
				obj.put("joinedDate", guardian.getJoinedDate());
				obj.put("adhaarNumber", guardian.getAdhaarNumber());
				obj.put("panId", guardian.getPanId());
				obj.put("nativePlace", guardian.getNativeplace());
				array.add(obj);
			}
			result.put("aaData", array);
			result.put("iTotalDisplayRecords", guardianrepo.findAll().size());
			result.put("iTotalRecords", guardianrepo.findAll().size());
//	      result.put("countByStatus", countByStatus);
		} catch (Exception e) {
			result.put("aaData", null);
			logger.error("Error:" + e.getMessage(), e);
			return result;
		}
		return result;
	}
	
	public JSONObject getAllAdmin(String searchParam, int start, int pageSize) {
		List<JSONObject> guardianDetails = new ArrayList<>();
		System.out.println("in to gell all guadian");
		JSONObject result = new JSONObject();
		try {

			Pageable pageable = PageRequest.of(start / pageSize, pageSize);
			Specification<AdminEntity> spec = AdminSpecification.getemailSpec(searchParam);
			Page<AdminEntity> usersPage = adminrepo.findAll(spec, pageable);
			JSONArray array = new JSONArray();
//	      JSONArray countByStatus = countByStatus(spec);
			System.out.println("before for loop");

			for (AdminEntity guardian : usersPage) {
				JSONObject obj = new JSONObject();
				System.out.println(guardian.getFirstName());
				obj.put("firstName", guardian.getFirstName());
				obj.put("lastName", guardian.getLastName());
				obj.put("age", guardian.getAge());
				obj.put("address", guardian.getAddress());
				obj.put("bloodGroup", guardian.getBloodgroup());
				obj.put("gender", guardian.getGender());
				obj.put("email", guardian.getEmail());
				obj.put("phone", guardian.getPhone());
				obj.put("joinedDate", guardian.getJoinedDate());
				obj.put("adhaarNumber", guardian.getAdhaarNumber());
				obj.put("panId", guardian.getPanId());
				obj.put("nativePlace", guardian.getNativeplace());
				array.add(obj);
			}
			result.put("aaData", array);
			result.put("iTotalDisplayRecords", guardianrepo.findAll().size());
			result.put("iTotalRecords", guardianrepo.findAll().size());
//	      result.put("countByStatus", countByStatus);
		} catch (Exception e) {
			result.put("aaData", null);
			logger.error("Error:" + e.getMessage(), e);
			return result;
		}
		return result;
	}

	public JSONObject getAllDoctorAppointment(String searchParam, int start, int pageSize) {
		List<JSONObject> guardianDetails = new ArrayList<>();
		System.out.println("in to gell all guadian");
		JSONObject result = new JSONObject();
		try {

			Pageable pageable = PageRequest.of(start / pageSize, pageSize);
			Specification<DoctorAppointmentEntity> spec = DoctorAppointmentSpecification.getQuestionSpec(searchParam);
			Page<DoctorAppointmentEntity> usersPage = doctorappointmentrepo.findAll(spec, pageable);
			JSONArray array = new JSONArray();
//	      JSONArray countByStatus = countByStatus(spec);
			System.out.println("before for loop");

			for (DoctorAppointmentEntity guardian : usersPage) {
				JSONObject obj = new JSONObject();
				obj.put("patientName", guardian.getPatientName());
				obj.put("doctorName", guardian.getDoctorName());
				obj.put("appointmentTime", guardian.getAppointmentTime());
				obj.put("AppointmentDate", guardian.getAppointmentDate());
				array.add(obj);
			}
			result.put("aaData", array);
			result.put("iTotalDisplayRecords", guardianrepo.findAll().size());
			result.put("iTotalRecords", guardianrepo.findAll().size());
//	      result.put("countByStatus", countByStatus);
		} catch (Exception e) {
			result.put("aaData", null);
			logger.error("Error:" + e.getMessage(), e);
			return result;
		}
		return result;
	}
	
	public ServiceResponse uploadResidentsMedicalReport(ResidentPdfFiles residenthealthdto)
	{
		try 
		{
			ResidentPdfFilesEntity residentEntity = residentpdffilesrepo.findByName(residenthealthdto.getName())
					.orElseThrow(() -> new RuntimeException("Guardian not found with ID: " + residenthealthdto.getId()));
	        
		residentEntity.setId(residenthealthdto.getId());
		residentEntity.setName(residenthealthdto.getName());
		if (residenthealthdto.getFullBodyTestResult() != null && !residenthealthdto.getFullBodyTestResult().isEmpty()) {
		    residentEntity.setFullBodyTestResult(residenthealthdto.getFullBodyTestResult().getBytes());
		}

		if (residenthealthdto.getBloodResult() != null && !residenthealthdto.getBloodResult().isEmpty()) {
		    residentEntity.setBloodResult(residenthealthdto.getBloodResult().getBytes());
		}

		if (residenthealthdto.getDietPlan() != null && !residenthealthdto.getDietPlan().isEmpty()) {
		    residentEntity.setDietPlan(residenthealthdto.getDietPlan().getBytes());
		}

		residentpdffilesrepo.save(residentEntity);
		return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_ADDED, null);

		}
			
	   catch(Exception e)
			
	    {
		   System.err.println("Error occurred while creating guardian: " + e.getMessage());
	
		    logger.error("Error : " + e.getMessage(), e);
	
			return new ServiceResponse(Constants.MESSAGE_STATUS.fail, "Failed to add guardian: " + e.getMessage(),null);
		}
		
	}
	
	public JSONObject getAllPatiennsPdfFiles() 
	{
		JSONObject result = new JSONObject();
		try {
//			Pageable pageable = PageRequest.of(start / pageSize, pageSize);
//			Specification<DoctorEntity> spec = DoctorSpecification.getQuestionSpec(searchParam);
			List<ResidentPdfFilesEntity> usersList = residentpdffilesrepo.findAll();
			JSONArray array = new JSONArray();
//	      JSONArray countByStatus = countByStatus(spec);
			for (ResidentPdfFilesEntity doctor : usersList) {
				JSONObject obj = new JSONObject();
				obj.put("id", doctor.getId());
				obj.put("name", doctor.getName());
				obj.put("fullbodyresult", doctor.getFullBodyTestResult());
				obj.put("bloodresult", doctor.getBloodResult());
				obj.put("dietplan", doctor.getDietPlan());
				obj.put("fullbodyresult", doctor.getLatestDoctorResult());

				array.add(obj);
			}
			result.put("aaData", array);
			result.put("iTotalDisplayRecords", doctorrepo.findAll().size());
			result.put("iTotalRecords", doctorrepo.findAll().size());
//	      result.put("countByStatus", countByStatus);
		} catch (Exception e) {
			result.put("aaData", null);
			logger.error("Error:" + e.getMessage(), e);
			return result;
		}
		return result;
	}
	
	public JSONObject loginFunction(LoginDTO logindto)
	{
		Optional<LoginEntity> userOptional = loginrepo.findById(logindto.getEmail());
        JSONObject response = new JSONObject();
        if (userOptional.isPresent()) 
        {
        	LoginEntity user = userOptional.get();
            if (user.getPassword().equals(logindto.getPassword())) {
                response.put("email", user.getEmail());
                response.put("role", user.getRole());
                response.put("login", "success");
                return response;
            }
            else
            {
                response.put("email", null);
                response.put("role", null);
                response.put("login", "fail");
                return response;
            	
            }
        }
        response.put("email", null);
        response.put("role", null);
        response.put("login", "fail");
        return response;

	}

    public ServiceResponse clearAllPatientsData() {
        try {
            residentrepo.deleteAll();
            residentpdffilesrepo.deleteAll();
            return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_LOG_SUCCESS, null);
        } catch (Exception e) {
            return new ServiceResponse(Constants.MESSAGE_STATUS.fail, e.getMessage(), null);
        }
    }

    public ServiceResponse clearAllDoctorsData() {
        try {
            doctorrepo.deleteAll();
            return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_LOG_SUCCESS, null);
        } catch (Exception e) {
            return new ServiceResponse(Constants.MESSAGE_STATUS.fail, e.getMessage(), null);
        }
    }

    public ServiceResponse clearAllAppointments() {
        try {
            doctorappointmentrepo.deleteAll();
            return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_LOG_SUCCESS, null);
        } catch (Exception e) {
            return new ServiceResponse(Constants.MESSAGE_STATUS.fail, e.getMessage(), null);
        }
    }

    public ServiceResponse clearAllLoginInformations() {
        try {
            loginrepo.deleteAll();
            return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_LOG_SUCCESS, null);
        } catch (Exception e) {
            return new ServiceResponse(Constants.MESSAGE_STATUS.fail, e.getMessage(), null);
        }
    }
    
	public ServiceResponse clearAllGuardianDatas()
	{
        try {
        	guardianrepo.deleteAll();
            return new ServiceResponse(Constants.MESSAGE_STATUS.success, Constants.USERLOG.USER_LOG_SUCCESS, null);
        } catch (Exception e) {
            return new ServiceResponse(Constants.MESSAGE_STATUS.fail, e.getMessage(), null);
        }
	}



}
