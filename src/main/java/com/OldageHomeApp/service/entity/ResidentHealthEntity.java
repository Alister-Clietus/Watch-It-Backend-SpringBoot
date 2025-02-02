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

    @Column(name = "blood_pressure", nullable = false, length = 15)
    private String bloodPressure; // e.g., "120/80 mmHg"

    @Column(name = "sugar_level", nullable = false, length = 20)
    private String sugarLevel; // e.g., "110 mg/dL"

    @Column(name = "cholesterol", nullable = false, length = 20)
    private String cholesterol; // e.g., "180 mg/dL"

    @Column(name = "is_able_to_walk", nullable = false)
    private Boolean isAbleToWalk; // true if the resident can walk, false otherwise

    @Column(name = "appointment_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date appointmentDate; // Next doctor's appointment date

    @Column(name = "recorded_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordedAt; // The date and time when the health record was logged

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

