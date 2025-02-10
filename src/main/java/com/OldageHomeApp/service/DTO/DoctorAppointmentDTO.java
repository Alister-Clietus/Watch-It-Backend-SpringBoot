package com.OldageHomeApp.service.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DoctorAppointmentDTO
{
    @NotBlank(message = "Patient name cannot be blank")
    @Size(min = 2, max = 100, message = "Patient name must be between 2 and 100 characters")
    private String patientName;

    @NotBlank(message = "Doctor name cannot be blank")
    @Size(min = 2, max = 100, message = "Doctor name must be between 2 and 100 characters")
    private String doctorName;

    @NotNull(message = "Appointment time cannot be null")
    private String appointmentTime;
    
    @NotNull(message = "Appointment datecannot be null")
    private String appointmentDDate;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getAppointmentDDate() {
		return appointmentDDate;
	}

	public void setAppointmentDDate(String appointmentDDate) {
		this.appointmentDDate = appointmentDDate;
	}
    
    
}
