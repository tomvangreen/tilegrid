package ch.digitalmeat.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import ch.digitalmeat.grid.chunk.ChunkCoordinates;
import ch.digitalmeat.grid.util.SimpleTileGridSerializer;

public class SimpleTileGridSerializerTest {

	private static final String TESTFOLDER = "testdata/";

	@Test
	public void testOutput() {
		SimpleTileGridSerializer<TestTile, TestChunk> serializer = new SimpleTileGridSerializer<>();
		TileGrid<TestTile, TestChunk> grid = new TileGrid<TestTile, TestChunk>(new TestFactory(), 32, 32);
		grid.ensureTile(1, 1);
		serializer.writeGrid(TESTFOLDER + "testOutput", grid);
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
