package ch.digitalmeat.grid.tile;

import ch.digitalmeat.grid.TileNavigator;
import ch.digitalmeat.grid.util.Direction;
import ch.digitalmeat.util.Point;

public class TileBase<T extends TileBase<T>> {
	public final Point coordinates = new Point();
	public final TileNavigator<T> navigator;

	public TileBase(TileNavigator<T> navigator) {
		this.navigator = navigator;
	}

	public T neighbour(Direction<?> direction) {
		navigator.setPosition(coordinates.x, coordinates.y);
		return navigator.step(direction, 1);
	}

}
