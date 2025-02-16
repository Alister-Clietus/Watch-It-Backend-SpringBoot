package com.OldageHomeApp.service.service;

import org.json.simple.JSONObject;

import com.OldageHomeApp.service.DTO.DoctorAppointmentDTO;
import com.OldageHomeApp.service.DTO.DoctorDTO;
import com.OldageHomeApp.service.DTO.GuardianDTO;
import com.OldageHomeApp.service.DTO.GuardianUpdateDTO;
import com.OldageHomeApp.service.DTO.ResidentPdfFiles;
import com.OldageHomeApp.service.DTO.ServiceResponse;

public interface GuardianService 
{
	public ServiceResponse createGuardian(GuardianDTO residentdto);
	public ServiceResponse getGuardian(long id);
	public JSONObject getAllGuardian(String searchParam,int start,int pageSize);
	public JSONObject getAllDoctor(String searchParam, int start, int pageSize);
	public ServiceResponse deleteGuardian(long id);
	public ServiceResponse updateGuardian(GuardianUpdateDTO residentdto);
	public ServiceResponse uploadResidentsMedicalReport(ResidentPdfFiles residentpdfentity);
	
//	Doctor Service
	
	public ServiceResponse createDoctor(DoctorDTO doctordto);
	public ServiceResponse doctorAppointment(DoctorAppointmentDTO doctordto);
	public JSONObject getAllDoctorAppointment(String searchParam, int int1, int int2);
	public JSONObject getAllPatiennsPdfFiles();

}
