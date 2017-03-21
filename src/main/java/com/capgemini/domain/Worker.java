package com.capgemini.domain;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "WORKER")
public class Worker extends AbstractEntity{


		private static final long serialVersionUID = 1L;
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    @Column(nullable = false, length = 45)
	    private String name;
	    @Column(nullable = false, length = 45)
	    private String surname;
	    @Column(nullable = false, length = 11)
	    private String pesel;
	    @Column (nullable = true)
	    private LocalDate birthDate;
	    @Column (nullable = true, length = 50)
	    private String email;
	    @Column (nullable = true, length = 10)
	    private String homePhoneNumber;
		@Column (nullable = true, length = 10)
	    private String mobilePhoneNumber;	
		
		@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
		@JoinColumn(name = "id_department")
		private Department department;
		
	    public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public void setPesel(String pesel) {
			this.pesel = pesel;
		}

		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setHomePhoneNumber(String homePhoneNumber) {
			this.homePhoneNumber = homePhoneNumber;
		}

		public void setMobilePhoneNumber(String mobilePhoneNumber) {
			this.mobilePhoneNumber = mobilePhoneNumber;
		}		

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Long getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getSurname() {
			return surname;
		}
		public String getPesel() {
			return pesel;
		}
		public LocalDate getBirthDate() {
			return birthDate;
		}
		public String getEmail() {
			return email;
		}
		public String getHomePhoneNumber() {
			return homePhoneNumber;
		}
		public String getMobilePhoneNumber() {
			return mobilePhoneNumber;
		}
 
	}

	

