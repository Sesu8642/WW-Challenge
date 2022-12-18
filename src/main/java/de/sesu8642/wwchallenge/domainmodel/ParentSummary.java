package de.sesu8642.wwchallenge.domainmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Summary of how many people have how many children. Only really makes sense as
 * a collection. The collection would contain for example: 5 people have 1
 * child, 4 people have 2 children etc.
 */
// not caching this entity as the result is already a kind of cache in the DB
@Entity
public class ParentSummary {

	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private long id;

	/** number of persons having {@link ParentSummary#amountOfChildren} children */
	@Column(unique = true)
	private Long amountOfPersons;

	/** number of children {@link ParentSummary#amountOfPersons} have */
	private Long amountOfChildren;

	public ParentSummary() {
		// default constructor for Hibernate
	}

	public ParentSummary(Long amountOfPersons, Long amountOfChildren) {
		this.amountOfPersons = amountOfPersons;
		this.amountOfChildren = amountOfChildren;
	}

	public Long getAmountOfPersons() {
		return amountOfPersons;
	}

	public void setAmountOfPersons(Long amountOfPersons) {
		this.amountOfPersons = amountOfPersons;
	}

	public Long getAmountOfChildren() {
		return amountOfChildren;
	}

	public void setAmountOfChildren(Long amountOfChildren) {
		this.amountOfChildren = amountOfChildren;
	}

}