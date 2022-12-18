package de.sesu8642.wwchallenge.persons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import de.sesu8642.wwchallenge.domainmodel.ParentSummary;

@ExtendWith(MockitoExtension.class)
class ParentSummaryDtoConversionTest {

	@Test
	void daoContainsZeros() {
		List<ParentSummary> testSummary = new ArrayList<>();
		testSummary.add(new ParentSummary(4L, 1L));
		testSummary.add(new ParentSummary(5L, 3L));
		
		var resultingDto = ParentSummaryDTO.fromSummaryList(testSummary);
		assertEquals(List.of(4L, 0L, 5L), resultingDto.summary());
	}
	
	@Test
	void daoOfEmptySummary() {
		List<ParentSummary> testSummary = new ArrayList<>();
		
		var resultingDto = ParentSummaryDTO.fromSummaryList(testSummary);
		assertTrue(resultingDto.summary().isEmpty());
	}
	
}
