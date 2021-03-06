package ch.digitalmeat.grid.tile;

import ch.digitalmeat.grid.TileNavigator;
import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.util.Direction;
import ch.digitalmeat.util.Point;

public class ChunkTileBase<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> extends TileBase<T> {

	public C chunk;
	public final Point globalCoordinates = new Point();

	public ChunkTileBase(TileNavigator<T> navigator) {
		super(navigator);
	}

	@Override
	public T neighbour(Direction<?> direction) {
		int x = coordinates.x;
		int y = coordinates.y;
		if (chunk != null) {
			x += chunk.coordinates.x * chunk.grid.chunkWidth;
			y += chunk.coordinates.y * chunk.grid.chunkHeight;
		}
		navigator.setPosition(x, y);
		return navigator.step(direction, 1);
	}

}
