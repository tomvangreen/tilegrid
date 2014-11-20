package ch.digitalmeat.grid.chunk;

import ch.digitalmeat.grid.ChunkGrid;
import ch.digitalmeat.grid.ChunkGridFactory;
import ch.digitalmeat.grid.tile.ChunkTileBase;
import ch.digitalmeat.grid.util.Coordinates;
import ch.digitalmeat.grid.util.Direction;
import ch.digitalmeat.grid.util.Table;

public class ChunkBase<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> {
	public final Coordinates coordinates;
	private Table<T> tiles;
	public ChunkGrid<T, C> grid;
	private final ChunkGridFactory<T, C> factory;

	public ChunkBase(ChunkGridFactory<T, C> factory) {
		this.factory = factory;
		coordinates = new Coordinates();
	}

	public void init(int x, int y, int width, int height) {
		coordinates.set(x, y);
		tiles = new Table<T>(width, height);
	}

	public T get(int localX, int localY) {
		return tiles.get(localX, localY);
	}

	public T ensure(int globalX, int globalY) {
		int localX = grid.getLocalX(globalX);
		int localY = grid.getLocalY(globalY);
		T tile = tiles.get(localX, localY);
		if (tile == null) {
			tile = factory.createTile(grid.navigator);
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
