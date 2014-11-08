package ch.digitalmeat.grid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TileCoordinatesTest {
	@Test
	public void testTileEquality() {
		ChunkCoordinates c1 = new ChunkCoordinates(5, 5);
		ChunkCoordinates c2 = new ChunkCoordinates(5, 5);
		TileCoordinates t1 = new TileCoordinates();
		t1.chunkCoordinates = c1;
		t1.localX = 1;
		t1.localY = 2;
		TileCoordinates t2 = new TileCoordinates();
		t2.chunkCoordinates = c2;
		t2.localX = 1;
		t2.localY = 2;
		assertEquals(t1, t2);
	}

}
