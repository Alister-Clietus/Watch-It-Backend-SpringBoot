package com.OldageHomeApp.service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AdminDTO 
{
	
	    @NotBlank(message = "First name cannot be blank")
	    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
	    private String firstName;

	    @NotBlank(message = "Last name cannot be blank")
	    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
	    private String lastName;
	    
	    @NotNull(message = "Age cannot be null")
	    @Min(value = 0, message = "Age must be greater than or equal to 0")
	    @Max(value = 150, message = "Age must be less than or equal to 150")
	    private String age;

	    @NotBlank(message = "Address cannot be blank")
	    private String address;

	    @NotBlank(message = "Blood group cannot be blank")
	    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group")
	    private String bloodgroup;

	    @NotBlank(message = "Gender cannot be blank")
	    @Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender")
	    private String gender;

	    @Email(message = "Invalid email address")
	    private String email;
	    
	    @NotBlank(message = "Password is required")
		private String password;
	    
	    @NotBlank(message = "Role is required")
		private String role;

	    @NotBlank(message = "Phone number cannot be blank")
	    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
	    private String phone;
	    
	    
	    @NotBlank(message = "Adhaar Number cannot be blank")
	    @Pattern(regexp = "^[0-9]{12}$", message = "Adhaar Number must be exactly 12 digits and contain only numbers")
	    private String adhaarNumber;
	    
	    @NotBlank(message = "Pan Card Id Number cannot be blank")
	    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Pan Card Id must be 10 characters: 5 letters, 4 digits, 1 letter (e.g., ABCDE1234F)")
	    private String panId;
	    
	    @NotBlank(message = "Native Place cannot be blank")
	    @Size(min = 2, max = 100, message = "Native Place must be between 2 and 100 characters")
	    private String nativeplace;

	    @NotBlank(message = "Joined date cannot be blank")
	    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Joined date must be in the format YYYY-MM-DD")
	    private String joineddate; // e.g., "2022-06-15"
	    
	    
	    
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
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
		public String getNativeplace() {
			return nativeplace;
		}
		public void setNativeplace(String nativeplace) {
			this.nativeplace = nativeplace;
		}
		public String getJoineddate() {
			return joineddate;
		}
		public void setJoineddate(String joineddate) {
			this.joineddate = joineddate;
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

}
