package ch.digitalmeat.grid.util;

public enum Direction4 implements Direction<Direction4> {
	//@formatter:off
	Up(0)
	, Right(1)
	, Down(2)
	, Left(3)
	;
	//@formatter:on

	public final int index;
	public final int flag;

	Direction4(int index) {
		this.index = index;
		this.flag = 1 << index;
	}

	@Override
	public int index() {
		return index;
	}

	@Override
	public int flag() {
		return flag;
	}

	@Override
	public Direction4 left() {
		return values()[(index + 3) % 4];
	}

	@Override
	public Direction4 right() {
		return values()[(index + 1) % 4];
	}

	@Override
	public Direction4 opposite() {
		return values()[(index + 2) % 4];
	}

	@Override
	public boolean isHorizontal() {
		return this == Left || this == Right;
	}

	@Override
	public boolean isVertical() {
		return this == Up || this == Down;
	}

	@Override
	public boolean isDiagonal() {
		return false;
	}

	@Override
	public int stepX() {
		if (this == Right) {
			return 1;
		}
		if (this == Left) {
			return -1;
		}
		return 0;
	}

	@Override
	public int stepY() {
		if (this == Up) {
			return 1;
		}
		if (this == Down) {
			return -1;
		}
		return 0;
	}

	private final static Direction4 directions[] = { Right, Up, Left, Down, Right };

	/**
	 * Returns an Direction4 value based on the input angle. Angle 0 is facing
	 * right and the angle goes counter clockwise (-90 => Down)
	 * 
	 * @param angle
	 *            The input angle.
	 * @return
	 */
	public static Direction4 getDirection(float angle) {
		return directions[(int) Math.round((((double) angle % 360) / 90))];
	}

}
