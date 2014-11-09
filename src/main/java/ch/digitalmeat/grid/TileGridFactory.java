package ch.digitalmeat.grid;

import ch.digitalmeat.grid.chunk.Chunk;
import ch.digitalmeat.grid.tile.TileBase;

public interface TileGridFactory<T extends TileBase<T>> {
	public Chunk<T> createChunk();

	public T createTile();
}
