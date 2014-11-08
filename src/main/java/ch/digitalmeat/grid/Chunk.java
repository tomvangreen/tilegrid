package ch.digitalmeat.grid;

public class Chunk<T extends TileBase<T>> {
	public final ChunkCoordinates coordinates;
	public final Table<T> tiles;
	public Grid<T> grid;
	private final GridFactory<T> factory;

	public Chunk(GridFactory<T> factory, int chunkX, int chunkY, int width, int height) {
		this.factory = factory;
		coordinates = new ChunkCoordinates(chunkX, chunkY);
		tiles = new Table<T>(width, height);
	}

	public T get(int localX, int localY) {
		return tiles.get(localX, localY);
	}

	public T ensure(int localX, int localY) {
		T tile = tiles.get(localX, localY);
		if (tile == null) {
			tile = factory.createTile();
			tile.localX = localX;
			tile.localY = localY;
			tile.chunk = this;
			tiles.set(localX, localY, tile);
		}
		return tile;
	}
}