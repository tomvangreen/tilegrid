package ch.digitalmeat.grid.util;

public class Point {
	public int x;
	public int y;

	public Point() {
		this(0, 0);
	}

	public Point(Point other) {
		this(other.x, other.y);
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void set(Point coordinates) {
		this.x = coordinates.x;
		this.y = coordinates.y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Point))
			return false;
		Point key = (Point) o;
		return x == key.x && y == key.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public String toString() {
		return x + "/" + y;
	}
}
