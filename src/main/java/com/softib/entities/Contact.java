package com.softib.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softib.entities.codes.ContactType;


@Entity
public class Contact {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	
	String contact ;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId", insertable=false, updatable=false)
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((contactType == null) ? 0 : contactType.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (contactType != other.contactType)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", contactType=" + contactType + ", contact=" + contact + "]";
	}

	public Contact() {
		super();
	}

	public Contact(int id, ContactType contactType, String contact) {
		super();
		this.id = id;
		this.contactType = contactType;
		this.contact = contact;
	}
	
	
	
}
