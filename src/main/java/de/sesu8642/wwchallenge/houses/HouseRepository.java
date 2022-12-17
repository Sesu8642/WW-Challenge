package de.sesu8642.wwchallenge.houses;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import de.sesu8642.wwchallenge.domainmodel.House;

/**
 * Repository for accessing data related to houses.
 */
public interface HouseRepository extends CrudRepository<House, Long> {
	
	Optional<House> findByResidentId(long personId);
	
}
