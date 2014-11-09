package ch.digitalmeat.grid;

import ch.digitalmeat.grid.chunk.Chunk;

public class TestFactory implements TileGridFactory<TestTile> {

	@Override
	public Chunk<TestTile> createChunk() {
		return new Chunk<TestTile>(this);
	}

	@Override
	public TestTile createTile() {
		return new TestTile();
	}

}
