package ch.digitalmeat.grid;

public interface TileGridSerializer<T extends TileBase<T>> {
	public TileGrid<T> readGrid(String gridFile);

	public void writeGrid(String gridFile, TileGrid<T> grid);

	public Chunk<T> readChunk(String chunkFile);

	public void writeChunk(String gridFile, Chunk<T> grid);
}
