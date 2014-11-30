package ch.digitalmeat.quadtree;

public abstract class QuadTreeBounds<BoundsType extends Number> {
	public final BoundsType x;
	public final BoundsType y;
	public final BoundsType width;
	public final BoundsType height;

	public abstract BoundsType getZero();

	public abstract boolean intersects(QuadTreeBounds<BoundsType> other);

	// public abstract boolean contains(QuadTreeBounds<BoundsType> other);

	// public abstract boolean contains(QuadTreePoint<BoundsType> point);

	public QuadTreeBounds(BoundsType x, BoundsType y, BoundsType width, BoundsType height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public BoundsType getX() {
		return x;
	}

	protected abstract QuadTreeBounds<BoundsType> instanciate(BoundsType x, BoundsType y, BoundsType width, BoundsType height);

	public abstract BoundsType halfWidth();

	public abstract BoundsType halfHeight();

	public abstract BoundsType xAndHalfWidth();

	public abstract BoundsType yAndHalfHeight();

	public abstract BoundsType x2();

	public abstract BoundsType y2();

	public QuadTreeBounds<BoundsType> getSubBounds(Quadrant quadrant) {
		BoundsType hw = halfWidth();
		BoundsType hh = halfHeight();
		BoundsType xhw = xAndHalfWidth();
		BoundsType yhh = yAndHalfHeight();
		switch (quadrant) {
		case SouthWest:
			return instanciate(x, y, hw, hh);
		case SouthEast:
			return instanciate(xhw, y, hw, hh);
		case NorthWest:
			return instanciate(x, yhh, hw, hh);
		case NorthEasts:
			return instanciate(xhw, yhh, hw, hh);
		default:
			throw new RuntimeException("No quadrant supplied for getSubBounds");
		}
	}

	public static class FloatBounds extends QuadTreeBounds<Float> {
		public FloatBounds(Float x, Float y, Float width, Float height) {
			super(x, y, width, height);
		}

		@Override
		public Float getZero() {
			return 0f;
		}

		@Override
		public boolean intersects(QuadTreeBounds<Float> other) {
			return (x < other.x2() && x2() > other.x && y < other.y2() && y2() > other.y);
		}

		@Override
		protected QuadTreeBounds<Float> instanciate(Float x, Float y, Float width, Float height) {
			return new FloatBounds(x, y, width, height);
		}

		@Override
		public Float halfWidth() {
			return width / 2;
		}

		@Override
		public Float halfHeight() {
			return height / 2;
		}

		@Override
		public Float xAndHalfWidth() {
			return x + width / 2;
		}

		@Override
		public Float yAndHalfHeight() {
			return y + height / 2;
		}

		@Override
		public Float x2() {
			return x + width;
		}

		@Override
		public Float y2() {
			return y + height;
		}

	};
}
