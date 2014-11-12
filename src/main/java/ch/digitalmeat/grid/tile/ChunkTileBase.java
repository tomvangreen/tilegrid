package ch.digitalmeat.grid.tile;

import ch.digitalmeat.grid.TileNavigator;
import ch.digitalmeat.grid.chunk.ChunkBase;

public class ChunkTileBase<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> extends TileBase<T> {

	public C chunk;

	public ChunkTileBase(TileNavigator<T> navigator) {
		super(navigator);
	}

}
