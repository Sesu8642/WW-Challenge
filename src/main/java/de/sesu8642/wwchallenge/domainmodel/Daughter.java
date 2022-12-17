package de.sesu8642.wwchallenge.domainmodel;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Daughter extends Child {

	/** hair color of the child */
	private String hairColor;

	public Daughter() {
		// default constructor for Hibernate
	}

	public Daughter(String name, Integer age, Person parent, List<Meal> favoriteMeals, String hairColor) {
		super(name, age, parent, favoriteMeals);
		this.hairColor = hairColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

}