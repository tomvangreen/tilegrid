package ch.digitalmeat.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import ch.digitalmeat.util.Point;

public class CoordinatesTest {
	@Test
	public void testChunkEquality() {
		Point c1 = new Point(5, 5);
		Point c2 = new Point(5, 5);
		assertEquals(c1, c2);
		c1.set(1, 3);
		c2.set(1, 3);
		assertEquals(c1, c2);
		c2.set(0, 1);
		assertNotEquals(c1, c2);
	}

}
