package ch.digitalmeat.grid;

import ch.digitalmeat.grid.tile.ChunkTileBase;

public class TestTile extends ChunkTileBase<TestTile, TestChunk> {

	public TestTile(TileNavigator<TestTile> navigator) {
		super(navigator);
	}

}
