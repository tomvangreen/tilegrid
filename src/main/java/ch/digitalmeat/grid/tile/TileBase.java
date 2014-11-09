package ch.digitalmeat.grid.tile;

import ch.digitalmeat.grid.TileGrid;
import ch.digitalmeat.grid.chunk.Chunk;
import ch.digitalmeat.grid.chunk.ChunkCoordinates;
import ch.digitalmeat.grid.util.Direction;

public class TileBase<T extends TileBase<T, C>, C extends Chunk<T, C>> {
	public int localX;
	public int localY;
	public Chunk<T, C> chunk;

	public T neighbour(Direction<?> direction) {
		if (chunk == null || chunk.grid == null) {
			return null;
		}
		TileGrid<T, C> grid = chunk.grid;
		ChunkCoordinates coordinates = chunk.coordinates;
		int worldX = grid.getGlobalX(coordinates.x, localX) + direction.stepX();
		int worldY = grid.getGlobalY(coordinates.y, localY) + direction.stepY();
		return chunk.grid.getTile(worldX, worldY);
	}

}
