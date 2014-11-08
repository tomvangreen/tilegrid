package ch.digitalmeat.grid;

public interface GridFactory<T extends TileBase<T>> {
	public Chunk<T> createChunk();

	public T createTile();
}
