package de.sesu8642.wwchallenge.persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service offering access to person data.
 */
@Service
public class PersonService implements IPersonService {

	private ParentSummaryRepository parentInfoRepository;

	@Autowired
	public PersonService(ParentSummaryRepository parentInfoRepository) {
		this.parentInfoRepository = parentInfoRepository;
	}
	
	@Override
	public ParentSummaryDTO getParentSummary() {
		return ParentSummaryDTO.fromSummaryList(parentInfoRepository.findAll());
	}

}
