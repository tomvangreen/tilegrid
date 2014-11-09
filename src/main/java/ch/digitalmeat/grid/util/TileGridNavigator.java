package ch.digitalmeat.grid.util;

import ch.digitalmeat.grid.TileGrid;
import ch.digitalmeat.grid.chunk.Chunk;
import ch.digitalmeat.grid.tile.TileBase;
import ch.digitalmeat.grid.tile.TileCoordinates;

public class TileGridNavigator<T extends TileBase<T, C>, C extends Chunk<T, C>> {
	public final TileGrid<T, C> grid;
	public final TileCoordinates coordinates = new TileCoordinates();

	public TileGridNavigator(TileGrid<T, C> grid) {
		this.grid = grid;
	}

	public boolean hasChunk() {
		return grid.getChunk(0, 0) != null;
	}

	public C chunk() {
		return grid.getChunk(0, 0);
	}

	public boolean hasTile() {
		return grid.getTile(coordinates) != null;
	}

	public T tile() {
		return grid.getTile(coordinates);
	}

	public void move(Direction direction, int steps) {

	}

}
