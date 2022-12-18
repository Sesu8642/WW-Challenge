package de.sesu8642.wwchallenge.persons;

/**
 * Interface for a service offering access to person data.
 */
public interface IPersonService {

	/**
	 * Gets a summary of how many persons have how many children.
	 * 
	 * @return DTO containing the information in the expected format.
	 */
	ParentSummaryDTO getParentSummary();

}