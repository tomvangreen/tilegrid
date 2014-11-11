package ch.digitalmeat.grid;

import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.tile.TileBase;

public interface TileGridFactory<T extends TileBase<T>, C extends ChunkBase<T, C>> {
	public C createChunk();

	public T createTile(TileNavigator<T> navigator);
}
