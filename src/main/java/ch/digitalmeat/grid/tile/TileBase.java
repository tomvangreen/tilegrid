package ch.digitalmeat.grid.tile;

import ch.digitalmeat.grid.TileGrid;
import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.chunk.ChunkCoordinates;
import ch.digitalmeat.grid.util.Direction;

public class TileBase<T extends TileBase<T, C>, C extends ChunkBase<T, C>> {
	public final TileCoordinates coordinates = new TileCoordinates();
	public ChunkBase<T, C> chunk;

	public T neighbour(Direction<?> direction) {
		if (chunk == null || chunk.grid == null) {
			return null;
		}
		TileGrid<T, C> grid = chunk.grid;
		ChunkCoordinates coordinates = chunk.coordinates;
		int worldX = grid.getGlobalX(coordinates.x, this.coordinates.localX) + direction.stepX();
		int worldY = grid.getGlobalY(coordinates.y, this.coordinates.localY) + direction.stepY();
		return chunk.grid.getTile(worldX, worldY);
	}

}
