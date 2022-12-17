package de.sesu8642.wwchallenge.children;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.sesu8642.wwchallenge.domainmodel.Daughter;
import de.sesu8642.wwchallenge.domainmodel.Son;

@ExtendWith(MockitoExtension.class)
class ChildServiceTest {

	@Mock
	private ChildRepository childRepositoryStub;

	@InjectMocks
	private ChildService systemUnderTest;

	final static long ID = 42;

	@Test
	void getBikeColorOfSon() {
		var son = new Son("Bobby", null, null, null, "yellow");
		when(childRepositoryStub.findById(ID)).thenReturn(Optional.of(son));

		var actualResult = systemUnderTest.findChildColorById(ID);
		var colorInfo = actualResult.get();

		assertTrue(colorInfo instanceof SonColorInfo);
		assertEquals(son.getBicycleColor(), ((SonColorInfo) colorInfo).bicycleColor());
	}

	@Test
	void getHairColorOfDaughter() {
		var daughter = new Daughter("Bonny", null, null, null, "brown");
		when(childRepositoryStub.findById(ID)).thenReturn(Optional.of(daughter));

		var actualResult = systemUnderTest.findChildColorById(ID);
		var colorInfo = actualResult.get();

		assertTrue(colorInfo instanceof DaughterColorInfo);
		assertEquals(daughter.getHairColor(), ((DaughterColorInfo) colorInfo).hairColor());
	}

	@Test
	void colorInfoOptionalIsEmptyForUnknownId() {
		var actualResult = systemUnderTest.findChildColorById(ID);
		assertTrue(actualResult.isEmpty());
	}

}
