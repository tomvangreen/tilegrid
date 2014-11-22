package ch.digitalmeat.grid;

import java.util.List;

import ch.digitalmeat.grid.tile.TileBase;

public interface Selector<T extends TileBase<T>> {
	public List<T> select(Bounds bounds);

	public List<T> select(int x, int y, int x2, int y2);

}