package ch.digitalmeat.grid;

public interface TileGridFactory<T extends TileBase<T>> {
	public Chunk<T> createChunk();

	public T createTile();
}
