package de.sesu8642.wwchallenge.houses;

import java.util.Optional;

import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import de.sesu8642.wwchallenge.domainmodel.House;
import jakarta.persistence.QueryHint;

/**
 * Repository for accessing data related to houses.
 */
public interface HouseRepository extends CrudRepository<House, Long> {
	
	@QueryHints(@QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true"))
	Optional<House> findByResidentId(long personId);
	
}
