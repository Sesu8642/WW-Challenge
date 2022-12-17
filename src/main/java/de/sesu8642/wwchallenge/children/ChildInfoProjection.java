package de.sesu8642.wwchallenge.children;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.sesu8642.wwchallenge.domainmodel.Meal;
import de.sesu8642.wwchallenge.domainmodel.Person;

/**
 * Projection on a child containing the parent and the favorite meal.
 */
public interface ChildInfoProjection {

	/** the child's parent */
	Person getParent();

	/** list of favorite meals of the child; order: most liked first */
	@JsonIgnore
	List<Meal> getFavoriteMeals();

	// could use an open projection instead but that would unnecessarily read all
	// the columns of the child
	default Meal getFavoriteMeal() {
		var favoriteMeals = getFavoriteMeals();
		return favoriteMeals.isEmpty() ? null : favoriteMeals.get(0);
	}
}
