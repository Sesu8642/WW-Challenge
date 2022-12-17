package de.sesu8642.wwchallenge.domainmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 * House that people live in.
 */
@Entity
public class House {

	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private long id;

	/** street and house number */
	private String address;

	/** zip code this house is located at */
	private String zipCode;

	/** type of this house, see {@link HouseType} */
	private HouseType type;

	/**
	 * the person living in this house; bidirectional because we want fast access to
	 * the house given only the person's id
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person resident;

	public House() {
		// default constructor for Hibernate
	}

	public House(String address, String zipCode, HouseType type, Person resident) {
		this.address = address;
		this.zipCode = zipCode;
		this.type = type;
		this.resident = resident;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public HouseType getType() {
		return type;
	}

	public void setType(HouseType type) {
		this.type = type;
	}

	public Person getResident() {
		return resident;
	}

	public void setResident(Person resident) {
		this.resident = resident;
	}

}
