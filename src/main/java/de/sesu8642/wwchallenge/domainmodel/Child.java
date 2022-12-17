package de.sesu8642.wwchallenge.domainmodel;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderColumn;

/**
 * Descendant of a {@link Person}.
 */
@Entity
public class Child {

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
	 * the parent of this child (limitation of the model: each child only has a
	 * single parent)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Person parent;

	/** list of favorite meals of the child; order: most liked first */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "child_favorite_meals", joinColumns = { @JoinColumn(name = "child_id") }, inverseJoinColumns = {
			@JoinColumn(name = "meal_id") })
	@OrderColumn
	private List<Meal> favoriteMeals;

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

	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

	public List<Meal> getFavoriteMeals() {
		return favoriteMeals;
	}

	public void setFavoriteMeals(List<Meal> favoriteMeals) {
		this.favoriteMeals = favoriteMeals;
	}

}