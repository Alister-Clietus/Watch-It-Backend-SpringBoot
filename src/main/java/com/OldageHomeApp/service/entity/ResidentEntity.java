package com.OldageHomeApp.service.entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "resident")
public class ResidentEntity 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Primary Key

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName; // First name of the resident

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName; // Last name of the resident

    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth; // Date of birth of the resident

    @Column(name = "gender", nullable = false, length = 10)
    private String gender; // Gender of the resident (e.g., Male/Female/Other)

    @Column(name = "address", nullable = false, length = 255)
    private String address; // Address of the resident

    @Column(name = "joined_date", nullable = false)
    private String joinedDate; // Date when the resident joined

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(String string) {
		this.joinedDate = string;
	}
    
    
}
