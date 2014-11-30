package ch.digitalmeat.grid;

import ch.digitalmeat.grid.tile.TileBase;
import ch.digitalmeat.grid.util.Direction;
import ch.digitalmeat.util.Table;

public class TableNavigator<T extends TileBase<T>> implements TileNavigator<T> {
	private int x;
	private int y;

	private final Table<T> table;

	public TableNavigator(Table<T> table) {
		this.table = table;
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
		return table.get(x, y);
	}

	@Override
	public T step(Direction<?> direction, int steps) {
		this.x += direction.stepX() * steps;
		this.y += direction.stepY() * steps;
		return get();
	}

}
