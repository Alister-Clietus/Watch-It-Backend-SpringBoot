package com.OldageHomeApp.service.DTO;

import java.util.Date;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;


public class ResidentHealthDTO 
{
	@NotNull(message = "ID cannot be null")
    private Long id;

    @NotBlank(message = "Blood pressure cannot be blank")
    @Pattern(regexp = "^\\d{2,3}/\\d{2,3} mmHg$", message = "Invalid blood pressure format. Example: '120/80 mmHg'")
    private String bloodPressure;  // e.g., "120/80 mmHg"

    @NotBlank(message = "Sugar level cannot be blank")
    @Pattern(regexp = "^\\d+ mg/dL$", message = "Invalid sugar level format. Example: '110 mg/dL'")
    private String sugarLevel;    // e.g., "110 mg/dL"

    @NotBlank(message = "Cholesterol level cannot be blank")
    @Pattern(regexp = "^\\d+ mg/dL$", message = "Invalid cholesterol level format. Example: '180 mg/dL'")
    private String cholesterol;   // e.g., "180 mg/dL"

    @NotNull(message = "Walking ability cannot be null")
    private Boolean isAbleToWalk; // true or false

    @FutureOrPresent(message = "Appointment date must be in the future or present")
    private Date appointmentDate; // Next doctor's appointment date

    @NotNull(message = "Recorded date cannot be null")
    @PastOrPresent(message = "Recorded date must be in the past or present")
    private Date recordedAt; // Date when the record was created
    
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
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Date getRecordedAt() {
		return recordedAt;
	}
	public void setRecordedAt(Date recordedAt) {
		this.recordedAt = recordedAt;
	} 
    
    

}
