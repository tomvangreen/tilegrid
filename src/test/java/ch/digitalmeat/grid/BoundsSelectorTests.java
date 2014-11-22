package ch.digitalmeat.grid;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BoundsSelectorTests {
	@Test
	public void testSelector1() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		grid.ensureTile(0, 0);
		grid.ensureTile(1, 0);

		List<TestTile> tiles = grid.selector.select(-10, -10, 10, 10, false);
		Assert.assertNotNull(tiles);
		Assert.assertEquals(2, tiles.size());
	}

	@Test
	public void testSelector2() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 4, 4);
		grid.ensureTile(0, 0);
		grid.ensureTile(5, 0);

		List<TestTile> tiles = grid.selector.select(0, 0, 4, 4, false);
		Assert.assertNotNull(tiles);
		Assert.assertEquals(1, tiles.size());

		tiles = grid.selector.select(4, 0, 8, 4, false);
		Assert.assertNotNull(tiles);
		Assert.assertEquals(1, tiles.size());

		tiles = grid.selector.select(0, 0, 8, 4, false);
		Assert.assertNotNull(tiles);
		Assert.assertEquals(2, tiles.size());
	}

	@Test
	public void testEnsure() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 2, 2);
		grid.ensureTile(0, 0);
		grid.ensureTile(3, 1);

		List<TestTile> tiles = grid.selector.select(0, 0, 3, 1, true);
		Assert.assertNotNull(tiles);
		Assert.assertEquals(8, tiles.size());

	}

	// TODO: Requires more tests
}
