package ch.digitalmeat.grid;


public class TestFactory implements TileGridFactory<TestTile, TestChunk> {

	@Override
	public TestChunk createChunk() {
		return new TestChunk(this);
	}

	@Override
	public TestTile createTile() {
		return new TestTile();
	}

}
