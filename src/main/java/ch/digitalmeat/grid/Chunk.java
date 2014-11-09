package ch.digitalmeat.grid;

public class Chunk<T extends TileBase<T>> {
	public final ChunkCoordinates coordinates;
	private Table<T> tiles;
	public TileGrid<T> grid;
	private final TileGridFactory<T> factory;

	public Chunk(TileGridFactory<T> factory) {
		this.factory = factory;
		coordinates = new ChunkCoordinates();
	}

	public void init(int width, int height) {
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
