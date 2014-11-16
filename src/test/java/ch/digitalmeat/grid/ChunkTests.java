package ch.digitalmeat.grid;

import org.junit.Assert;
import org.junit.Test;

import ch.digitalmeat.grid.util.Direction8;

public class ChunkTests {
	@Test
	public void testNavigator() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);

		TestTile tile1 = grid.ensureTile(0, 0);
		TestTile tile2 = grid.ensureTile(1, 0);
		Assert.assertEquals(tile2, tile1.neighbour(Direction8.Right));
	}
}
