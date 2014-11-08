package ch.digitalmeat.grid;

import java.util.HashMap;
import java.util.Map;

public class ChunkManager<T extends TileBase<T>> {
	public final Map<ChunkCoordinates, Chunk<T>> chunks = new HashMap<ChunkCoordinates, Chunk<T>>();
	public final GridFactory<T> factory;

	private final Grid<T> grid;
	private final ChunkCoordinates finderCoordinates = new ChunkCoordinates();

	public ChunkManager(GridFactory<T> factory, Grid<T> grid) {
		this.factory = factory;
		this.grid = grid;
	}

	public Chunk<T> get(int x, int y) {
		finderCoordinates.set(x, y);
		return get(finderCoordinates);
	}

	public Chunk<T> get(ChunkCoordinates coordinates) {
		return chunks.get(coordinates);
	}

	public Chunk<T> ensure(int x, int y) {
		finderCoordinates.set(x, y);
		return ensure(finderCoordinates);
	}

	public Chunk<T> ensure(ChunkCoordinates coordinates) {
		Chunk<T> chunk = chunks.get(coordinates);
		if (chunk == null) {
			chunk = factory.createChunk();
			chunk.coordinates.set(coordinates.x, coordinates.y);
			chunk.grid = grid;
			chunks.put(chunk.coordinates, chunk);
		}
		return chunk;
	}

}
