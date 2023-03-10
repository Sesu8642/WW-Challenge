package de.sesu8642.wwchallenge.domainmodel;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * A type of dish.
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Meal {

	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private long id;

	/** name of the meal */
	private String name;

	/** date this meal was invented */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date invented;

	public Meal() {
		// default constructor for Hibernate
	}

	public Meal(String name, Date invented) {
		this.name = name;
		this.invented = invented;
	}

	@Override
	public int hashCode() {
		return Objects.hash(invented, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Meal)) {
			return false;
		}
		Meal other = (Meal) obj;
		return Objects.equals(invented, other.invented) && Objects.equals(name, other.name);
	}

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

	public Date getInvented() {
		return invented;
	}

	public void setInvented(Date invented) {
		this.invented = invented;
	}

}
