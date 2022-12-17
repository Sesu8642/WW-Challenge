package de.sesu8642.wwchallenge.children;

import java.util.Optional;

/**
 * Interface for a service offering access to child data.
 */
public interface IChildService {

	/**
	 * Finds information about a child with the given ID.
	 * 
	 * @param childId ID of the child to find information about
	 * @return Optional containing the info as a {@link ChildInfoProjection} or empty optional if the child was not
	 *         found
	 */
	Optional<ChildInfoProjection> findChildInfoById(long childId);

}