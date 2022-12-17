package de.sesu8642.wwchallenge.children;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sesu8642.wwchallenge.domainmodel.Daughter;
import de.sesu8642.wwchallenge.domainmodel.Son;

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

	@Override
	public Optional<IColorInfo> findChildColorById(long childId) {
		var childOptional = childRepository.findById(childId);
		if (childOptional.isEmpty()) {
			// no child found --> no color either
			return Optional.empty();
		}
		var child = childOptional.get();
		if (Daughter.class.isAssignableFrom(child.getClass())) {
			return Optional.of(new DaughterColorInfo(((Daughter) child).getHairColor()));
		} else if (Son.class.isAssignableFrom(child.getClass())) {
			return Optional.of(new SonColorInfo(((Son) child).getBicycleColor()));
		} else {
			throw new IllegalStateException("Unexpected child class: " + child.getClass());
		}
	}

}
