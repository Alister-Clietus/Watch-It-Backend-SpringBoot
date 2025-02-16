package com.OldageHomeApp.service.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "medical_reports_pdf")
public class ResidentPdfFilesEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

//    @Column(name = "full_body_test_result", columnDefinition = "LONGBLOB")
    @Column(name = "full_body_test_result", columnDefinition = "BYTEA")
    private byte[] fullBodyTestResult;
    
//  @Column(name = "full_body_test_result", columnDefinition = "LONGBLOB")
    @Column(name = "latestDoctorResult", columnDefinition = "BYTEA")
    private byte[] latestDoctorResult;

//  @Column(name = "full_body_test_result", columnDefinition = "LONGBLOB")
    @Column(name = "bloodResult", columnDefinition = "BYTEA")
    private byte[] bloodResult;

//  @Column(name = "full_body_test_result", columnDefinition = "LONGBLOB")
    @Column(name = "dietPlan", columnDefinition = "BYTEA")
    private byte[] dietPlan;
    
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

	public byte[] getFullBodyTestResult() {
		return fullBodyTestResult;
	}

	public void setFullBodyTestResult(byte[] fullBodyTestResult) {
		this.fullBodyTestResult = fullBodyTestResult;
	}

	public byte[] getLatestDoctorResult() {
		return latestDoctorResult;
	}

	public void setLatestDoctorResult(byte[] latestDoctorResult) {
		this.latestDoctorResult = latestDoctorResult;
	}

	public byte[] getBloodResult() {
		return bloodResult;
	}

	public void setBloodResult(byte[] bloodResult) {
		this.bloodResult = bloodResult;
	}

	public byte[] getDietPlan() {
		return dietPlan;
	}

	public void setDietPlan(byte[] dietPlan) {
		this.dietPlan = dietPlan;
	}
	
	
	




    
    
}

