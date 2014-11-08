package ch.digitalmeat.grid;

public class TileBase<T extends TileBase<T>> {
	public int localX;
	public int localY;
	public Chunk<T> chunk;

	public T neighbour(Direction<?> direction) {
		if (chunk == null || chunk.grid == null) {
			return null;
		}
		TileGrid<T> grid = chunk.grid;
		ChunkCoordinates coordinates = chunk.coordinates;
		int worldX = grid.getGlobalX(coordinates.x, localX) + direction.stepX();
		int worldY = grid.getGlobalY(coordinates.y, localY) + direction.stepY();
		return chunk.grid.getTile(worldX, worldY);
	}

}
