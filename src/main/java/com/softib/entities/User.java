package com.softib.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.softib.entities.codes.IdentityType;
import com.softib.entities.codes.MaritalStatus;
import com.softib.entities.codes.Nationality;
import com.softib.entities.codes.Role;
import com.softib.entities.codes.Sexe;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@SequenceGenerator(name="seq")
	private int userId;
	
	@Column(unique=true)
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String identityNumber;
	@Enumerated(EnumType.STRING)
	private IdentityType identityType;
	private Date creationDate;
	private Date updateDate;
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
	@Enumerated(EnumType.STRING)
	private Nationality nationality;
	@Enumerated(EnumType.STRING)
	private Role role;
	private Boolean isActive;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String activationKey;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Adress> adresses;
	

	@OneToMany(cascade = CascadeType.ALL)
	List<Contact> contacts;

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + userId;
		return result;
	}




	public Boolean getIsActive() {
		return isActive;
	}




	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}






	public User(int userId, String email, String password, String firstName, String lastName, Date dateOfBirth,
			String identityNumber, IdentityType identityType, Date creationDate, Date updateDate, Sexe sexe,
			MaritalStatus maritalStatus, Nationality nationality, Role role, Boolean isActive, String activationKey,
			List<Adress> adresses, List<Contact> contacts) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.identityNumber = identityNumber;
		this.identityType = identityType;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.sexe = sexe;
		this.maritalStatus = maritalStatus;
		this.nationality = nationality;
		this.role = role;
		this.isActive = isActive;
		this.activationKey = activationKey;
		this.adresses = adresses;
		this.contacts = contacts;
	}




	public String getActivationKey() {
		return activationKey;
	}




	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
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




	public String getIdentityNumber() {
		return identityNumber;
	}




	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}




	public IdentityType getIdentityType() {
		return identityType;
	}




	public void setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
	}




	public Date getCreationDate() {
		return creationDate;
	}




	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}




	public Date getUpdateDate() {
		return updateDate;
	}




	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}




	public Sexe getSexe() {
		return sexe;
	}




	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}




	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}




	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}




	public Nationality getNationality() {
		return nationality;
	}




	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}




	public Role getRole() {
		return role;
	}




	public void setRole(Role role) {
		this.role = role;
	}




	public List<Adress> getAdresses() {
		return adresses;
	}




	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}




	public List<Contact> getContacts() {
		return contacts;
	}




	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
