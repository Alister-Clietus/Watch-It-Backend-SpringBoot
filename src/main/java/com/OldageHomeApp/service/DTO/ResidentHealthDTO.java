package com.OldageHomeApp.service.DTO;

import java.util.Date;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class ResidentHealthDTO 
{
	@NotNull(message = "ID cannot be null")
    private Long id;
	

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
    private String lastName;

    private String bloodPressure;  // e.g., "120/80 mmHg"

    private String sugarLevel;    // e.g., "110 mg/dL"

    private String cholesterol;   // e.g., "180 mg/dL"

    private Boolean isAbleToWalk; // true or false

    private String appointmentDate; // Next doctor's appointment date

    private String recordedAt; // Date when the record was created
    
    
    
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getSugarLevel() {
		return sugarLevel;
	}
	public void setSugarLevel(String sugarLevel) {
		this.sugarLevel = sugarLevel;
	}
	public String getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(String cholesterol) {
		this.cholesterol = cholesterol;
	}
	public Boolean getIsAbleToWalk() {
		return isAbleToWalk;
	}
	public void setIsAbleToWalk(Boolean isAbleToWalk) {
		this.isAbleToWalk = isAbleToWalk;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getRecordedAt() {
		return recordedAt;
	}
	public void setRecordedAt(String recordedAt) {
		this.recordedAt = recordedAt;
	}
 
    
    

}
