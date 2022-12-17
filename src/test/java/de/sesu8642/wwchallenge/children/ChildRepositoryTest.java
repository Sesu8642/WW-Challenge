package de.sesu8642.wwchallenge.children;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import de.sesu8642.wwchallenge.domainmodel.Child;
import de.sesu8642.wwchallenge.domainmodel.Meal;
import de.sesu8642.wwchallenge.domainmodel.Person;

@DataJpaTest
class ChildRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ChildRepository systemUnderTest;

	@Test
	void childInfoContainsCorrectFavoriteMeal() throws Exception {
		var pizzaMeal = new Meal("Pizza Napoletana", new Date(43534));
		var spaghettiMeal = new Meal("Spaghetti", new Date(234));
		var eggMeal = new Meal("Scrambled Eggs", new Date(123));
		var childWithMultipleFavoriteMeals = new Child(null, null, null, List.of(pizzaMeal, spaghettiMeal, eggMeal));

		entityManager.persist(spaghettiMeal);
		// persisting the pizza meal in the middle to make sure the id is not relevant for the order
		entityManager.persist(pizzaMeal);
		entityManager.persist(eggMeal);
		var persistedChild = entityManager.persist(childWithMultipleFavoriteMeals);

		var childInfoOptional = systemUnderTest.findChildInfoById(persistedChild.getId());
		var childInfo = childInfoOptional.get();

		// the first meal in the list is the (most) favorite one that should be in the
		// info
		assertEquals(pizzaMeal, childInfo.getFavoriteMeal());
	}

	@Test
	void childInfoContainsParent() throws Exception {
		var parent = new Person("Mom", 42, null);
		var childWithParent = new Child(null, null, parent, null);
		
		entityManager.persist(parent);
		var persistedChild = entityManager.persist(childWithParent);
		
		var childInfoOptional = systemUnderTest.findChildInfoById(persistedChild.getId());
		var childInfo = childInfoOptional.get();
		
		assertEquals(parent, childInfo.getParent());
	}

	@Test
	void childInfoOptionalIsEmptyForUnknownId() throws Exception {
		var childInfoOptional = systemUnderTest.findChildInfoById(0);
		assertTrue(childInfoOptional.isEmpty());
	}
}
