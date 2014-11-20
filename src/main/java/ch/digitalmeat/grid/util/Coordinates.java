package ch.digitalmeat.grid.util;

public class Coordinates {
	public int x;
	public int y;

	public Coordinates() {
		this(0, 0);
	}

	public Coordinates(Coordinates other) {
		this(other.x, other.y);
	}

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void set(Coordinates coordinates) {
		this.x = coordinates.x;
		this.y = coordinates.y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Coordinates))
			return false;
		Coordinates key = (Coordinates) o;
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
