package de.sesu8642.wwchallenge.children;

import org.springframework.beans.factory.annotation.Value;

import de.sesu8642.wwchallenge.domainmodel.Meal;
import de.sesu8642.wwchallenge.domainmodel.Person;

/**
 * Projection on a child containing the parent and the favorite meal.
 */
public interface ChildInfoProjection {

	/** the child's parent */
	Person getParent();

	/** the child's favorite meal */
	@Value("#{target.favoriteMeals[0]}")
	Meal getFavoriteMeal();
}
