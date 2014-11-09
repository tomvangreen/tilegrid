package ch.digitalmeat.grid.chunk;

import ch.digitalmeat.grid.TileGrid;
import ch.digitalmeat.grid.TileGridFactory;
import ch.digitalmeat.grid.tile.TileBase;
import ch.digitalmeat.grid.util.Direction;
import ch.digitalmeat.grid.util.Table;

public class ChunkBase<T extends TileBase<T, C>, C extends ChunkBase<T, C>> {
	public final ChunkCoordinates coordinates;
	private Table<T> tiles;
	public TileGrid<T, C> grid;
	private final TileGridFactory<T, C> factory;

	public ChunkBase(TileGridFactory<T, C> factory) {
		this.factory = factory;
		coordinates = new ChunkCoordinates();
	}

	public void init(int x, int y, int width, int height) {
		coordinates.set(x, y);
		// TODO: Free items
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
			tiles.set(localX, localY, tile);
			tile.chunk = this;
		}
		return tile;
	}

	public C neighbour(Direction<?> direction) {
		if (grid == null) {
			return null;
		}
		int chunkX = coordinates.x + direction.stepX();
		int chunkY = coordinates.y + direction.stepY();
		return grid.getChunk(chunkX, chunkY);
	}
}
