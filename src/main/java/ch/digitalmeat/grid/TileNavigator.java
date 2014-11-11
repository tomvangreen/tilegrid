package ch.digitalmeat.grid;

import ch.digitalmeat.grid.tile.TileBase;
import ch.digitalmeat.grid.util.Direction;

public interface TileNavigator<T extends TileBase<T>> {
	public int getX();

	public int getY();

	public void setPosition(int x, int y);

	public T get();

	public T step(Direction<?> direction, int steps);
}
