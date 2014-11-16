package ch.digitalmeat.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import ch.digitalmeat.grid.util.Coordinates;

public class CoordinatesTest {
	@Test
	public void testChunkEquality() {
		Coordinates c1 = new Coordinates(5, 5);
		Coordinates c2 = new Coordinates(5, 5);
		assertEquals(c1, c2);
		c1.set(1, 3);
		c2.set(1, 3);
		assertEquals(c1, c2);
		c2.set(0, 1);
		assertNotEquals(c1, c2);
	}

}
