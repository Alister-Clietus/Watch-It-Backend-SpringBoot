package com.OldageHomeApp.service.service;

import com.OldageHomeApp.service.DTO.ResidentDTO;
import com.OldageHomeApp.service.DTO.ResidentHealthDTO;
import com.OldageHomeApp.service.DTO.ServiceResponse;

public interface ResidentService 
{
	
	public ServiceResponse createResident(ResidentDTO residentdto);
	public ServiceResponse getResident(long id);
	public ServiceResponse deleteResident(long id);
	public ServiceResponse updateResident(ResidentDTO residentdto);
	public ServiceResponse addResidentHealthDetails(ResidentHealthDTO residenthealthdto);
	public ServiceResponse UpdateResidentHealthDetails(ResidentHealthDTO residenthealthdto);

}
