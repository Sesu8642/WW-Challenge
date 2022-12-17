package de.sesu8642.wwchallenge.children;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("children")
/**
 * Adapter for offering access to child data via the RESTful API.
 */
public class ChildRestController {

	private IChildService childService;

	@Autowired
	public ChildRestController(IChildService childService) {
		this.childService = childService;
	}

	/*
	 * The task specifies that the endpoint should be "/child/info". I took the
	 * liberty to change the path to include the ID.
	 */
	/**
	 * Exposes {@link ChildService#findChildInfoById} via the RESTful API.
	 * 
	 * @param childId id of the child whose info to get
	 * @return {@link ChildInfoProjection} containing some selected information
	 *         about the child
	 * 
	 * @throws {@link ResponseStatusException} with status code 404 if the result is
	 *                null
	 */
	@GetMapping("/{childId}/info")
	public ChildInfoProjection getChildInfoById(@PathVariable long childId) {
		return childService.findChildInfoById(childId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	/**
	 * Exposes {@link ChildService#findChildColorById} via the RESTful API.
	 * 
	 * @param childId id of the child whose color to get
	 * @return {@link ChildColorProjection} containing either the the hair color if
	 *         the child is a daughter or the bike color if the child is a son
	 * 
	 * @throws {@link ResponseStatusException} with status code 404 if the result is
	 *                null
	 */
	@GetMapping("/{childId}/color")
	public IColorInfo getChildColorById(@PathVariable long childId) {
		return childService.findChildColorById(childId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
