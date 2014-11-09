package ch.digitalmeat.grid.util;

import ch.digitalmeat.grid.TileGrid;
import ch.digitalmeat.grid.chunk.Chunk;
import ch.digitalmeat.grid.tile.TileBase;

public interface TileGridSerializer<T extends TileBase<T, C>, C extends Chunk<T, C>> {
	public TileGrid<T, C> readGrid(String gridFile);

	public void writeGrid(String gridFile, TileGrid<T, C> grid);

	public C readChunk(String chunkFile);

	public void writeChunk(String gridFile, C grid);
}
