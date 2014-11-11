package ch.digitalmeat.grid;

import ch.digitalmeat.grid.tile.TileBase;
import ch.digitalmeat.grid.util.Direction;

public class TileGridNavigator<T extends TileBase<T>> implements TileNavigator<T> {
	private int x;
	private int y;

	private final TileGrid<T, ?> grid;

	public TileGridNavigator(TileGrid<T, ?> grid) {
		this.grid = grid;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
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
