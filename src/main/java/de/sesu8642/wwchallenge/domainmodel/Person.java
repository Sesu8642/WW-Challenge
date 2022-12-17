package de.sesu8642.wwchallenge.domainmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/**
 * A person.
 */
@Entity
public class Person {

	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private long id;

	/** full name */
	private String name;

	/** age in years at the time of data acquisition */
	private Integer age;

	/**
	 * the house this person lives in; a unidirectional relationship would suffice
	 * for the given task but it seems reasonable to have easy access to a person's
	 * address
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "house_id")
	private House house;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}