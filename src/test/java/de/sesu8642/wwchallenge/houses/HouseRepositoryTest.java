package de.sesu8642.wwchallenge.houses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import de.sesu8642.wwchallenge.domainmodel.House;
import de.sesu8642.wwchallenge.domainmodel.HouseType;
import de.sesu8642.wwchallenge.domainmodel.Person;

@DataJpaTest
class HouseRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private HouseRepository systemUnderTest;

	@Test
	void houseIsReturnedForOwner() throws Exception {
		var house = new House("ABC Street", "12345", HouseType.ESTATE, null);
		var resident = new Person("Bob", 42, null);
		house.setResident(resident);

		var persistedResident = entityManager.persist(resident);
		entityManager.persist(house);

		var retreivedHouseOptional = systemUnderTest.findByResidentId(persistedResident.getId());
		var retreivedHouse = retreivedHouseOptional.get();

		assertEquals(house, retreivedHouse);
	}

	@Test
	void houseInfoOptionalIsEmptyForUnknownId() throws Exception {
		var retreivedHouseOptional = systemUnderTest.findByResidentId(0);
		assertTrue(retreivedHouseOptional.isEmpty());
	}
}
