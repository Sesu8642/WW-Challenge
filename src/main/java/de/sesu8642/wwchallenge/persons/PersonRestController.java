package de.sesu8642.wwchallenge.persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
/**
 * Adapter for offering access to person data via the RESTful API.
 */
public class PersonRestController {

	private IPersonService personService;

	@Autowired
	public PersonRestController(IPersonService personService) {
		this.personService = personService;
	}

	/**
	 * Exposes {@link PersonService#getParentSummary()} via the RESTful API.
	 * 
	 * @return summary as list in a DTO
	 */
	@GetMapping("/children")
	public ParentSummaryDTO getChildInfoById() {
		return personService.getParentSummary();
	}

}
