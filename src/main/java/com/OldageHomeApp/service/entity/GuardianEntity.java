package com.OldageHomeApp.service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "guardian")
public class GuardianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Primary Key

    @Column(name = "age", nullable = false, length = 3)
    private String age; // Guardian's age

    @Column(name = "address", nullable = false, length = 255)
    private String address; // Address of the guardian

    @Column(name = "blood_group", nullable = true, length = 10)
    private String bloodgroup; // Blood group of the guardian

    @Column(name = "gender", nullable = false, length = 10)
    private String gender; // Gender of the guardian (e.g., Male/Female/Other)

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email; // Email of the guardian

    @Column(name = "phone", nullable = false, unique = true, length = 15)
    private String phone; // Phone number of the guardian

    @Column(name = "resident_id", nullable = false)
    private Long residentId; // Reference to the associated resident's ID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getResidentId() {
		return residentId;
	}

	public void setResidentId(Long residentId) {
		this.residentId = residentId;
	}
    
    
}
