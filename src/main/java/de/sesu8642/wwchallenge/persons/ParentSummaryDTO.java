package de.sesu8642.wwchallenge.persons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import de.sesu8642.wwchallenge.domainmodel.ParentSummary;

/**
 * DTO for the parent info summary, to achieve the expected JSON format.
 */
public record ParentSummaryDTO(List<Long> summary) {

	/**
	 * Returns a summary of how many persons have how many children, format example:
	 * [4, 7] --> 4 persons have no children, 7 persons have one child etc.
	 * 
	 * @param listOfSummaryObjects list of summary objects
	 * @return DTO containing the summary information in the expected format
	 */
	public static ParentSummaryDTO fromSummaryList(List<ParentSummary> listOfSummaryObjects) {
		if (listOfSummaryObjects.isEmpty()) {
			return new ParentSummaryDTO(Collections.emptyList());
		}
		// map keys = amount of children, values = amount of persons
		var parentSummaryMap = listOfSummaryObjects.stream()
				.collect(Collectors.toMap(ParentSummary::getAmountOfChildren, ParentSummary::getAmountOfPersons));
		var maxAmountOfChildren = Collections.max(parentSummaryMap.keySet());
		List<Long> summaryList = new ArrayList<>();
		for (Long i = 1L; i < maxAmountOfChildren + 1; i++) {
			summaryList.add(parentSummaryMap.getOrDefault(i, 0L));
		}
		return new ParentSummaryDTO(summaryList);
	}

}
