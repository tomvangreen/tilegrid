package ch.digitalmeat.grid;

import ch.digitalmeat.grid.chunk.ChunkBase;

public class TestChunk extends ChunkBase<TestTile, TestChunk> {
	public TestChunk(TestFactory factory) {
		super(factory);
	}

}
