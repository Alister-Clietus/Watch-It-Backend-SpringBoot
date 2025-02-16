package com.OldageHomeApp.service.DTO;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;

public class ResidentPdfFiles 
{
    private Long id;
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private MultipartFile latestDoctorResult;

    private MultipartFile bloodResult;

    private MultipartFile dietPlan;
    
    

    public MultipartFile getLatestDoctorResult() {
		return latestDoctorResult;
	}

	public void setLatestDoctorResult(MultipartFile latestDoctorResult) {
		this.latestDoctorResult = latestDoctorResult;
	}

	public MultipartFile getBloodResult() {
		return bloodResult;
	}

	public void setBloodResult(MultipartFile bloodResult) {
		this.bloodResult = bloodResult;
	}

	public MultipartFile getDietPlan() {
		return dietPlan;
	}

	public void setDietPlan(MultipartFile dietPlan) {
		this.dietPlan = dietPlan;
	}

	private MultipartFile fullBodyTestResult;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFullBodyTestResult() {
		return fullBodyTestResult;
	}

	public void setFullBodyTestResult(MultipartFile fullBodyTestResult) {
		this.fullBodyTestResult = fullBodyTestResult;
	}


    
    

}
