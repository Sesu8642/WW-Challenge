package de.sesu8642.wwchallenge.children;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import de.sesu8642.wwchallenge.domainmodel.Child;

/**
 * Repository for accessing data related to children.
 */
public interface ChildRepository extends CrudRepository<Child, Long> {
	
	Optional<ChildInfoProjection> findChildInfoById(long id);
	
}
