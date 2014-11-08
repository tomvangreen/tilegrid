package ch.digitalmeat.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ChunkCoordinatesTest {
	@Test
	public void testChunkEquality() {
		ChunkCoordinates c1 = new ChunkCoordinates(5, 5);
		ChunkCoordinates c2 = new ChunkCoordinates(5, 5);
		assertEquals(c1, c2);
		c1.set(1, 3);
		c2.set(1, 3);
		assertEquals(c1, c2);
		c2.set(0, 1);
		assertNotEquals(c1, c2);
	}

}
