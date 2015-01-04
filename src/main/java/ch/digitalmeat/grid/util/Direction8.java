package ch.digitalmeat.grid.util;

public enum Direction8 implements Direction<Direction8> {
	//@formatter:off
	Up(0)
	, UpRight(1)
	, Right(2)
	, DownRight(3)
	, Down(4)
	, DownLeft(5)
	, Left(6)
	, UpLeft(7)
	;
	//@formatter:on

	public final int index;
	public final int flag;

	Direction8(int index) {
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
	public Direction8 left() {
		return values()[(index + 7) % 8];
	}

	@Override
	public Direction8 right() {
		return values()[(index + 1) % 8];
	}

	@Override
	public Direction8 opposite() {
		return values()[(index + 4) % 8];
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
		return !(isHorizontal() || isVertical());
	}

	@Override
	public int stepX() {
		if (this == Right || this == UpRight || this == DownRight) {
			return 1;
		}
		if (this == Left || this == UpLeft || this == DownLeft) {
			return -1;
		}
		return 0;
	}

	@Override
	public int stepY() {
		if (this == Up || this == UpLeft || this == UpRight) {
			return 1;
		}
		if (this == Down || this == DownLeft || this == DownRight) {
			return -1;
		}
		return 0;
	}

	private final static Direction8 directions[] = { Right, DownRight, Down, DownLeft, Left, UpLeft, Up, UpRight, Right };

	public static Direction8 getDirection(float angle) {
		while (angle < 0) {
			angle += 360;
		}
		return directions[(int) Math.round((((double) angle % 360) / 45))];
	}

}
