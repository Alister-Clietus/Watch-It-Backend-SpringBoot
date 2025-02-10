package com.OldageHomeApp.service.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ResidentUpdateDTO 
{
	
//	Total 15 variables
	
	private Long id;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
    private String lastName;
    
    
    @NotBlank(message = "Adhaar Number cannot be blank")
    @Pattern(regexp = "^[0-9]{12}$", message = "Adhaar Number must be exactly 12 digits and contain only numbers")
    private String adhaarNumber;
    
    @NotBlank(message = "Pan Card Id Number cannot be blank")
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Pan Card Id must be 10 characters: 5 letters, 4 digits, 1 letter (e.g., ABCDE1234F)")
    private String panId;
   
    @NotBlank(message = "Number of children cannot be blank")
    @Pattern(regexp = "^[0-9]+$", message = "Number of children must contain only digits")
    private String no_of_childrens;
    
    @NotBlank(message = "Native Place cannot be blank")
    @Size(min = 2, max = 100, message = "Native Place must be between 2 and 100 characters")
    private String nativeplace;

    @NotBlank(message = "Guardian cannot be blank")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
    private String guardian;
    
    @NotBlank(message = "Birth Place cannot be blank")
    @Size(min = 2, max = 100, message = "Birth Place must be between 2 and 100 characters")
    private String birthPlace;
    
    @NotBlank(message = "Joined date cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Joined date must be in the format YYYY-MM-DD")    
    private String dateOfBirth;

    @NotBlank(message = "Gender cannot be blank")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be one of the following: Male, Female, Other")
    private String gender;

    @NotBlank(message = "Address cannot be blank")
    private String address;
    
    @NotBlank(message = "Blood Group cannot be blank")
    private String bloodGroup;
    
    @NotBlank(message = "Weight cannot be blank")
    private String weight;
    
    @NotBlank(message = "Height cannot be blank")
    private String height;

    @NotBlank(message = "Joined date cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Joined date must be in the format YYYY-MM-DD")
    private String joineddate; // e.g., "2022-06-15"

    
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

	public String getJoineddate() {
		return joineddate;
	}

	public void setJoineddate(String joineddate) {
		this.joineddate = joineddate;
	}
    
    
    
    
}