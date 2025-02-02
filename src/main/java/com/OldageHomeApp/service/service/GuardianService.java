package com.OldageHomeApp.service.service;

import com.OldageHomeApp.service.DTO.GuardianDTO;
import com.OldageHomeApp.service.DTO.GuardianUpdateDTO;
import com.OldageHomeApp.service.DTO.ServiceResponse;

public interface GuardianService 
{
	public ServiceResponse createGuardian(GuardianDTO residentdto);
	public ServiceResponse getGuardian(long id);
	public ServiceResponse deleteGuardian(long id);
	public ServiceResponse updateGuardian(GuardianUpdateDTO residentdto);


}
