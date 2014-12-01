package ch.digitalmeat.grid.quadtree;

public abstract class QuadTreePoint<BoundsType extends Number> {
	private BoundsType x;
	private BoundsType y;

	public abstract BoundsType getZero();

	public BoundsType getX() {
		return x == null ? getZero() : x;
	}

	public void setX(BoundsType x) {
		this.x = x;
	}

	public BoundsType getY() {
		return y == null ? getZero() : y;
	}

	public void setY(BoundsType y) {
		this.y = y;
	}
}
