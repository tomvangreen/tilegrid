package ch.digitalmeat.grid.chunk;

import ch.digitalmeat.grid.ChunkGrid;
import ch.digitalmeat.grid.ChunkGridFactory;
import ch.digitalmeat.grid.tile.ChunkTileBase;
import ch.digitalmeat.grid.util.Direction;
import ch.digitalmeat.grid.util.Table;
import ch.digitalmeat.util.Point;

public class ChunkBase<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> {
	public final Point coordinates;
	private Table<T> tiles;
	public ChunkGrid<T, C> grid;
	private final ChunkGridFactory<T, C> factory;

	public ChunkBase(ChunkGridFactory<T, C> factory) {
		this.factory = factory;
		coordinates = new Point();
	}

	public void init(int x, int y, int width, int height) {
		coordinates.set(x, y);
		tiles = new Table<T>(width, height);
	}

	public T get(int localX, int localY) {
		return tiles.get(localX, localY);
	}

	public T ensure(int localX, int localY) {
		T tile = tiles.get(localX, localY);
		if (tile == null) {
			int globalX = coordinates.x * grid.chunkWidth + localX;
			int globalY = coordinates.y * grid.chunkHeight + localY;
			tile = factory.createTile(grid.navigator, globalX, globalY);
			tile.coordinates.x = localX;
			tile.coordinates.y = localY;
			tile.globalCoordinates.x = globalX;
			tile.globalCoordinates.y = globalY;
			tile.chunk = get();
			tiles.set(localX, localY, tile);
		}
		return tile;
	}

	public C get() {
		return (C) this;
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
