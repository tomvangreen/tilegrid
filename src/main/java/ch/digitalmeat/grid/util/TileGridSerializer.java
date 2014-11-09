package ch.digitalmeat.grid.util;

import ch.digitalmeat.grid.TileGrid;
import ch.digitalmeat.grid.chunk.Chunk;
import ch.digitalmeat.grid.tile.TileBase;

public interface TileGridSerializer<T extends TileBase<T>> {
	public TileGrid<T> readGrid(String gridFile);

	public void writeGrid(String gridFile, TileGrid<T> grid);

	public Chunk<T> readChunk(String chunkFile);

	public void writeChunk(String gridFile, Chunk<T> grid);
}
