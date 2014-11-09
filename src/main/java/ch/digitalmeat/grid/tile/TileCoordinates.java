package ch.digitalmeat.grid.tile;

import ch.digitalmeat.grid.chunk.ChunkCoordinates;

public class TileCoordinates {
	public final ChunkCoordinates chunkCoordinates = new ChunkCoordinates();
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
