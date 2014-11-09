package ch.digitalmeat.grid.util;

public interface Direction<D> {

	public int index();

	public int flag();

	public D left();

	public D right();

	public D opposite();

	public boolean isHorizontal();

	public boolean isVertical();

	public boolean isDiagonal();

	public int stepX();

	public int stepY();

}
