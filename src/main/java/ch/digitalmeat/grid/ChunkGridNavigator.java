package ch.digitalmeat.grid;

import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.tile.ChunkTileBase;
import ch.digitalmeat.grid.util.Direction;

/**
 * Currently the chunk grid navigator only supports coordinates that are in
 * integer range...
 * 
 * @author atombrot
 *
 * @param <T>
 * @param <C>
 */
public class ChunkGridNavigator<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> implements TileNavigator<T> {
	private int x;
	private int y;

	private final ChunkGrid<T, C> grid;

	public ChunkGridNavigator(ChunkGrid<T, C> grid) {
		this.grid = grid;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public T get() {
		return grid.getTile(x, y);
	}

	@Override
	public T step(Direction<?> direction, int steps) {
		this.x += direction.stepX() * steps;
		this.y += direction.stepY() * steps;
		return get();
	}

}
