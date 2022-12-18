package de.sesu8642.wwchallenge.domainmodel;

import java.util.List;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class Son extends Child {

	/** color of this child's bicycle */
	private String bicycleColor;

	public Son() {
		// default constructor for Hibernate
	}

	public Son(String name, Integer age, Person parent, List<Meal> favoriteMeals, String bicycleColor) {
		super(name, age, parent, favoriteMeals);
		this.bicycleColor = bicycleColor;
	}

	public String getBicycleColor() {
		return bicycleColor;
	}

	public void setBicycleColor(String bicycleColor) {
		this.bicycleColor = bicycleColor;
	}

}