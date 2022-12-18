package de.sesu8642.wwchallenge.persons;

import org.springframework.data.repository.ListCrudRepository;

import de.sesu8642.wwchallenge.domainmodel.ParentSummary;

/**
 * Repository for accessing parent summary data.
 */
public interface ParentSummaryRepository extends ListCrudRepository<ParentSummary, Long> {}
