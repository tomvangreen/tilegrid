package ch.digitalmeat.grid.util;

import ch.digitalmeat.grid.TileGrid;
import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.tile.TileBase;

public interface TileGridSerializer<T extends TileBase<T>, C extends ChunkBase<T, C>> {
	public TileGrid<T, C> readGrid(String gridFile);

	public void writeGrid(String gridFile, TileGrid<T, C> grid);

	public C readChunk(String chunkFile);

	public void writeChunk(String gridFile, C grid);
}
