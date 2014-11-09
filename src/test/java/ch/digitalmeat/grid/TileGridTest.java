package ch.digitalmeat.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ch.digitalmeat.grid.chunk.ChunkCoordinates;

public class TileGridTest {
	@Test
	public void testAllTilesNull() {
		int width = 16;
		int height = 16;
		TileGrid<?> grid = new TileGrid<>(null, 16, 16);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				assertNull(grid.getTile(x, y));
			}
		}
	}

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
