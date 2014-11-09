package ch.digitalmeat.grid.chunk;

public class ChunkCoordinates {
	public int x;
	public int y;

	public ChunkCoordinates() {
		this(0, 0);
	}

	public ChunkCoordinates(ChunkCoordinates other) {
		this(other.x, other.y);
	}

	public ChunkCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof ChunkCoordinates) {
			ChunkCoordinates other = (ChunkCoordinates) object;
			return x == other.x && y == other.y;
		}
		return false;
	}

	public void set(ChunkCoordinates coordinates) {
		this.x = coordinates.x;
		this.y = coordinates.y;
	}
}
