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

	@Test
	public void testPositiveChunkCoordinatesX() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);

		Assert.assertEquals(0, grid.getChunkX(0));
		Assert.assertEquals(0, grid.getChunkX(1));
		Assert.assertEquals(1, grid.getChunkX(8));
	}

	@Test
	public void testNegativeChunkCoordinatesX() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);

		Assert.assertEquals(-1, grid.getChunkX(-1));
		Assert.assertEquals(-1, grid.getChunkX(-2));
		Assert.assertEquals(-1, grid.getChunkX(-3));
		Assert.assertEquals(-1, grid.getChunkX(-4));
		Assert.assertEquals(-1, grid.getChunkX(-5));
		Assert.assertEquals(-1, grid.getChunkX(-6));
		Assert.assertEquals(-1, grid.getChunkX(-7));
		Assert.assertEquals(-1, grid.getChunkX(-8));
		Assert.assertEquals(-2, grid.getChunkX(-9));
	}

	@Test
	public void testPositiveChunkCoordinatesY() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);

		Assert.assertEquals(0, grid.getChunkY(0));
		Assert.assertEquals(0, grid.getChunkY(1));
		Assert.assertEquals(1, grid.getChunkY(8));
	}

	@Test
	public void testNegativeChunkCoordinatesY() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);

		Assert.assertEquals(-1, grid.getChunkY(-1));
		Assert.assertEquals(-1, grid.getChunkY(-8));
		Assert.assertEquals(-2, grid.getChunkY(-9));

	}

	@Test
	public void testPostiveGlobalCoordinatesX() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		Assert.assertEquals(0, grid.getGlobalX(0, 0));
		Assert.assertEquals(5, grid.getGlobalX(0, 5));
		Assert.assertEquals(8, grid.getGlobalX(1, 0));
	}

	@Test
	public void testNegativeGlobalCoordinatesX() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		Assert.assertEquals(-8, grid.getGlobalX(-1, 0));
		Assert.assertEquals(-1, grid.getGlobalX(-1, 7));
		Assert.assertEquals(-9, grid.getGlobalX(-2, 7));
	}

	@Test
	public void testPostiveGlobalCoordinatesY() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		Assert.assertEquals(0, grid.getGlobalY(0, 0));
		Assert.assertEquals(5, grid.getGlobalY(0, 5));
		Assert.assertEquals(8, grid.getGlobalY(1, 0));
	}

	@Test
	public void testNegativeGlobalCoordinatesY() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		Assert.assertEquals(-8, grid.getGlobalY(-1, 0));
		Assert.assertEquals(-1, grid.getGlobalY(-1, 7));
		Assert.assertEquals(-9, grid.getGlobalY(-2, 7));
	}

	@Test
	public void testPositiveLocalCoordinatesX() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		Assert.assertEquals(0, grid.getLocalX(0));
		Assert.assertEquals(0, grid.getLocalX(8));
		Assert.assertEquals(7, grid.getLocalX(7));
		Assert.assertEquals(7, grid.getLocalX(15));
	}

	@Test
	public void testPositiveLocalCoordinatesY() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		Assert.assertEquals(0, grid.getLocalY(0));
		Assert.assertEquals(0, grid.getLocalY(8));
		Assert.assertEquals(7, grid.getLocalY(7));
		Assert.assertEquals(7, grid.getLocalY(15));
	}

	@Test
	public void testNegativeLocalCoordinatesX() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		Assert.assertEquals(7, grid.getLocalX(-1));
		Assert.assertEquals(0, grid.getLocalX(-8));
		Assert.assertEquals(7, grid.getLocalX(-9));
		Assert.assertEquals(0, grid.getLocalX(-16));
	}

	@Test
	public void testNegativeLocalCoordinatesY() {
		TestFactory factory = new TestFactory();
		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(factory, 8, 8);
		Assert.assertEquals(0, grid.getLocalY(-16));
		Assert.assertEquals(0, grid.getLocalY(-8));
		Assert.assertEquals(7, grid.getLocalY(-1));
		Assert.assertEquals(7, grid.getLocalY(-9));
	}

}
