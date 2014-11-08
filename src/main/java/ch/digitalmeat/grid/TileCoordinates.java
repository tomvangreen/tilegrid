package ch.digitalmeat.grid;

public class TileCoordinates {
	public ChunkCoordinates chunkCoordinates;
	public int localX;
	public int localY;

	@Override
	public boolean equals(Object object) {
		if (object instanceof TileCoordinates) {
			TileCoordinates other = (TileCoordinates) object;
			return chunkCoordinates.equals(other.chunkCoordinates) && localX == other.localX && localY == other.localY;
		}
		return false;
	}
}
