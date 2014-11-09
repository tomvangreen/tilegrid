package ch.digitalmeat.grid;

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
