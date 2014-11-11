package ch.digitalmeat.grid.tile;

import ch.digitalmeat.grid.TileNavigator;

public class TileBase<T extends TileBase<T>> {
	public final TileCoordinates coordinates = new TileCoordinates();
	public final TileNavigator<T> navigator;

	public TileBase(TileNavigator<T> navigator) {
		this.navigator = navigator;
	}

}
