package ch.digitalmeat.grid.util;

import ch.digitalmeat.grid.ChunkGrid;
import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.tile.ChunkTileBase;

public interface TileGridSerializer<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> {
	public ChunkGrid<T, C> readGrid(String gridFile);

	public void writeGrid(String gridFile, ChunkGrid<T, C> grid);

	public C readChunk(String chunkFile);

	public void writeChunk(String gridFile, C grid);
}
