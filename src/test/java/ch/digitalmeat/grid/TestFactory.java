package ch.digitalmeat.grid;

public class TestFactory implements ChunkGridFactory<TestTile, TestChunk> {

	@Override
	public TestChunk createChunk() {
		return new TestChunk(this);
	}

	@Override
	public TestTile createTile(TileNavigator<TestTile> navigator, int globalX, int globalY) {
		return new TestTile(navigator);
	}

}
