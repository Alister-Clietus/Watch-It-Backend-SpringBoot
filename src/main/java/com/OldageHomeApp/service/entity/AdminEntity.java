package com.OldageHomeApp.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "admin")
public class AdminEntity 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id; // Primary Key
	    
	    @Column(name = "first_name", nullable = false, length = 50)
	    private String firstName; // First name of the resident

	    @Column(name = "last_name", nullable = false, length = 50)
	    private String lastName; // Last name of the resident

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

	    
	    @Column(name = "joined_date", nullable = false)
	    private String joinedDate; // Date when the resident joined
	    
	    @Column(name = "adhaar_number", nullable = false, length = 50)
	    private String adhaarNumber;
	    
	    @Column(name = "pan_id", nullable = false, length = 50)
	    private String panId;
	    
	    @Column(name = "native_place", nullable = false, length = 50)
	    private String nativeplace;
	    
	    

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

		public String getJoinedDate() {
			return joinedDate;
		}

		public void setJoinedDate(String joinedDate) {
			this.joinedDate = joinedDate;
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

}
