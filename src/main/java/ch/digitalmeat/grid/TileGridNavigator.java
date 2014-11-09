package ch.digitalmeat.grid;

public class TileGridNavigator<T extends TileBase<T>> {
	public final TileGrid<T> grid;
	public final TileCoordinates coordinates = new TileCoordinates();

	public TileGridNavigator(TileGrid<T> grid) {
		this.grid = grid;
	}

	public boolean hasChunk() {
		return grid.getChunk(0, 0) != null;
	}

	public Chunk<T> chunk() {
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
