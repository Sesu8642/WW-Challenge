package de.sesu8642.wwchallenge.houses;

import java.util.Optional;

import de.sesu8642.wwchallenge.domainmodel.House;

/**
 * Interface for a service offering access to housing data.
 */
public interface IHouseService {

	/**
	 * Finds housing information for a given resident.
	 * 
	 * @param personId ID of the person whose housing information to get
	 * @return Optional containing the info as a {@link House} or empty optional if
	 *         the person was not found
	 */
	Optional<House> findHouseByResidentId(long personId);

}