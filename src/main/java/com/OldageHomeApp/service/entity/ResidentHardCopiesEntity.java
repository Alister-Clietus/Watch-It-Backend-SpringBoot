package com.OldageHomeApp.service.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "residents")
public class ResidentHardCopiesEntity 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "resident_photo", nullable = false)
    private byte[] residentPhoto; // Store as binary data

    @Lob
    @Column(name = "resident_medical_record", nullable = false)
    private byte[] residentMedicalRecord; // Store as binary data

    @Lob
    @Column(name = "blood_result", nullable = false)
    private String bloodResult; // Store as a large string

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getResidentPhoto() {
		return residentPhoto;
	}

	public void setResidentPhoto(byte[] residentPhoto) {
		this.residentPhoto = residentPhoto;
	}

	public byte[] getResidentMedicalRecord() {
		return residentMedicalRecord;
	}

	public void setResidentMedicalRecord(byte[] residentMedicalRecord) {
		this.residentMedicalRecord = residentMedicalRecord;
	}

	public String getBloodResult() {
		return bloodResult;
	}

	public void setBloodResult(String bloodResult) {
		this.bloodResult = bloodResult;
	}

    

}
