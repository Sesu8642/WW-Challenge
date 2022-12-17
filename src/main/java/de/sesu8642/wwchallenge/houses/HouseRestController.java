package de.sesu8642.wwchallenge.houses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.sesu8642.wwchallenge.domainmodel.House;

@RestController
/**
 * Adapter for offering access to child data via the RESTful API.
 */
public class HouseRestController {

	private IHouseService houseService;

	@Autowired
	public HouseRestController(IHouseService houseService) {
		this.houseService = houseService;
	}

	/*
	 * The task specifies that the endpoint should be "/house". I took the liberty
	 * to include the person in the path as well to have a meaningful way to
	 * transmit the ID.
	 */
	/**
	 * Exposes {@link HouseService#findHouseByResidentId} via the RESTful API.
	 * 
	 * @param personId id of the person whose housing details to get
	 * @return {@link House} the person lives in
	 * 
	 * @throws {@link ResponseStatusException} with status code 404 if the result is
	 *                null
	 */
	@GetMapping("/persons/{personId}/house")
	public House getHouseOfPerson(@PathVariable long personId) {
		return houseService.findHouseByResidentId(personId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
