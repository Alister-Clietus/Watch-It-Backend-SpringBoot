package com.OldageHomeApp.service.DTO;

public class ResidentHardCopiesDTO 
{
    private Long id;
    private String residentPhoto; // Base64 encoded string
    private String residentMedicalRecord; // Base64 encoded string
    private String bloodResult;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResidentPhoto() {
		return residentPhoto;
	}
	public void setResidentPhoto(String residentPhoto) {
		this.residentPhoto = residentPhoto;
	}
	public String getResidentMedicalRecord() {
		return residentMedicalRecord;
	}
	public void setResidentMedicalRecord(String residentMedicalRecord) {
		this.residentMedicalRecord = residentMedicalRecord;
	}
	public String getBloodResult() {
		return bloodResult;
	}
	public void setBloodResult(String bloodResult) {
		this.bloodResult = bloodResult;
	}
    
    

}
