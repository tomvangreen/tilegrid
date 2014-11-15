package ch.digitalmeat.grid.tile;

import ch.digitalmeat.grid.TileNavigator;
import ch.digitalmeat.grid.util.Direction;

public class TileBase<T extends TileBase<T>> {
	public final TileCoordinates coordinates = new TileCoordinates();
	public final TileNavigator<T> navigator;

	public TileBase(TileNavigator<T> navigator) {
		this.navigator = navigator;
	}

	public T neighbour(Direction<?> direction) {
		navigator.setPosition(coordinates.localX, coordinates.localY);
		return navigator.step(direction, 1);
	}

}
