package com.OldageHomeApp.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "resident")
public class ResidentEntity 
{

//	Total 16 variables for the table
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Primary Key

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName; // First name of the resident

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName; // Last name of the resident
    
    @Column(name = "adhaar_number", nullable = false, length = 50)
    private String adhaarNumber;
    
    @Column(name = "pan_id", nullable = false, length = 50)
    private String panId;
    
    @Column(name = "no_of_childrens", nullable = false, length = 50)
    private String no_of_childrens;
    
    @Column(name = "native_place", nullable = false, length = 50)
    private String nativeplace;
    
    @Column(name = "guardian_name", nullable = false, length = 50)
    private String guardian;
    
    @Column(name = "birth_place", nullable = false, length = 50)
    private String birthPlace;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth; // Date of birth of the resident

    @Column(name = "gender", nullable = false, length = 10)
    private String gender; // Gender of the resident (e.g., Male/Female/Other)

    @Column(name = "address", nullable = false, length = 255)
    private String address; // Address of the resident
    
    @Column(name = "blood_group", nullable = false, length = 255)
    private String bloodGroup;
    
    @Column(name = "weight", nullable = false, length = 255)
    private String weight;
    
    @Column(name = "height", nullable = false, length = 255)
    private String height;

    @Column(name = "joined_date", nullable = false)
    private String joinedDate; // Date when the resident joined
    
    
    

	public String getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(String adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	public String getPanId() {
		return panId;
	}

	public void setPanId(String panId) {
		this.panId = panId;
	}

	public String getNo_of_childrens() {
		return no_of_childrens;
	}

	public void setNo_of_childrens(String no_of_childrens) {
		this.no_of_childrens = no_of_childrens;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
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
