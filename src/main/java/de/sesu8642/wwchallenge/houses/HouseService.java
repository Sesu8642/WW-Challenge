package de.sesu8642.wwchallenge.houses;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.sesu8642.wwchallenge.domainmodel.House;

/**
 * Service offering access to housing data.
 */
@Service
public class HouseService implements IHouseService {

	private HouseRepository houseRepository;

	@Autowired
	public HouseService(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

	@Override
	public Optional<House> findHouseByResidentId(long personId) {
		return houseRepository.findByResidentId(personId);
	}

}
