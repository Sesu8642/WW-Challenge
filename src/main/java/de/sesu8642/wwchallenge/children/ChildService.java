package de.sesu8642.wwchallenge.children;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service offering access to child data.
 */
@Service
public class ChildService implements IChildService {

	private ChildRepository childRepository;

	@Autowired
	public ChildService(ChildRepository childRepository) {
		this.childRepository = childRepository;
	}

	@Override
	public Optional<ChildInfoProjection> findChildInfoById(long childId) {
		return childRepository.findChildInfoById(childId);
	}

}
