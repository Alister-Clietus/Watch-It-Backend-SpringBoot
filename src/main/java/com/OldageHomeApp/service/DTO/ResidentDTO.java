package com.OldageHomeApp.service.DTO;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ResidentDTO 
{

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
    private String lastName;
    
//    @NotEmpty(message = "Age cannot be blank")
    private int age;
    
    @NotBlank(message = "Adhaar Number cannot be blank")
    private String adhaarNumber;
    
    @NotBlank(message = "Pan Card Id Number cannot be blank")
    private String panId;
    
    @NotBlank(message = "No of Childrens cannot be blank")
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
    
    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth must be a past date")
    private Date dateOfBirth;

    @NotBlank(message = "Gender cannot be blank")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be one of the following: Male, Female, Other")
    private String gender;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "Joined date cannot be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Joined date must be in the format YYYY-MM-DD")
    private String joineddate; // e.g., "2022-06-15"
    
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
	public String getJoineddate() {
		return joineddate;
	}
	public void setJoineddate(String joineddate) {
		this.joineddate = joineddate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
    
    

}
