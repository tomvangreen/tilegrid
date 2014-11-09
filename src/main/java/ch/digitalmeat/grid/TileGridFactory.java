package ch.digitalmeat.grid;

import ch.digitalmeat.grid.chunk.Chunk;
import ch.digitalmeat.grid.tile.TileBase;

public interface TileGridFactory<T extends TileBase<T, C>, C extends Chunk<T, C>> {
	public C createChunk();

	public T createTile();
}
