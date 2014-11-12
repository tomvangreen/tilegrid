package ch.digitalmeat.grid;

import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.tile.ChunkTileBase;

public interface ChunkGridFactory<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> {
	public C createChunk();

	public T createTile(TileNavigator<T> navigator);
}
