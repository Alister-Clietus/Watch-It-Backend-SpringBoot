package com.OldageHomeApp.service.service;

import org.json.simple.JSONObject;

import com.OldageHomeApp.service.DTO.ResidentDTO;
import com.OldageHomeApp.service.DTO.ResidentHealthDTO;
import com.OldageHomeApp.service.DTO.ResidentUpdateDTO;
import com.OldageHomeApp.service.DTO.ServiceResponse;

public interface ResidentService 
{
	
	public ServiceResponse createResident(ResidentDTO residentdto);
	public ServiceResponse getResident(long id);
	public JSONObject getAllResident(String searchParam,int start,int pageSize);
	public ServiceResponse deleteResident(long id);
	public ServiceResponse updateResident(ResidentUpdateDTO residentdto);
	public ServiceResponse addResidentHealthDetails(ResidentHealthDTO residenthealthdto);
	public ServiceResponse UpdateResidentHealthDetails(ResidentHealthDTO residenthealthdto);

}
