package com.OldageHomeApp.service.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "resident_health")
public class ResidentHealthEntity 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Primary Key
    
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName; // First name of the resident

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName; 

    @Column(name = "blood_pressure", nullable = true, length = 15)
    private String bloodPressure; // e.g., "120/80 mmHg"

    @Column(name = "sugar_level", nullable = true, length = 20)
    private String sugarLevel; // e.g., "110 mg/dL"

    @Column(name = "cholesterol", nullable = true, length = 20)
    private String cholesterol; // e.g., "180 mg/dL"

    @Column(name = "is_able_to_walk", nullable = true)
    private Boolean isAbleToWalk; // true if the resident can walk, false otherwise

    @Column(name = "appointment_date", nullable = true)
    private String appointmentDate; // Next doctor's appointment date

    @Column(name = "recorded_at", nullable = true)
    private String recordedAt; // The date and time when the health record was logged
    
    
    
    
    

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


    
    
}

