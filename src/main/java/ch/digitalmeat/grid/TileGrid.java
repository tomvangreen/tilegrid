package ch.digitalmeat.grid;

import java.util.HashMap;
import java.util.Map;

import ch.digitalmeat.grid.chunk.Chunk;
import ch.digitalmeat.grid.chunk.ChunkCoordinates;
import ch.digitalmeat.grid.tile.TileBase;
import ch.digitalmeat.grid.tile.TileCoordinates;

public class TileGrid<T extends TileBase<T>> {
	public final TileGridFactory<T> factory;
	public final int chunkWidth;
	public final int chunkHeight;
	private final ChunkCoordinates finderCoordinates = new ChunkCoordinates();
	public final Map<ChunkCoordinates, Chunk<T>> chunks = new HashMap<ChunkCoordinates, Chunk<T>>();

	public TileGrid(TileGridFactory<T> factory, int chunkWidth, int chunkHeight) {
		this.factory = factory;
		this.chunkWidth = chunkWidth;
		this.chunkHeight = chunkHeight;
	}

	public Chunk<T> getChunk(int chunkX, int chunkY) {
		finderCoordinates.set(chunkX, chunkY);
		return getChunk(finderCoordinates);
	}

	public Chunk<T> getChunk(ChunkCoordinates coordinates) {
		return chunks.get(coordinates);
	}

	public Chunk<T> ensureChunk(int chunkX, int chunkY) {
		finderCoordinates.set(chunkX, chunkY);
		return ensureChunk(finderCoordinates);
	}

	public Chunk<T> ensureChunk(ChunkCoordinates coordinates) {
		Chunk<T> chunk = chunks.get(coordinates);
		if (chunk == null) {
			chunk = factory.createChunk();
			chunk.coordinates.set(coordinates.x, coordinates.y);
			chunk.init(chunkWidth, chunkHeight);
			chunk.grid = this;
			chunks.put(chunk.coordinates, chunk);
		}
		return chunk;
	}

	public int getChunkX(int globalX) {
		return globalX / chunkWidth;
	}

	public int getChunkY(int globalY) {
		return globalY / chunkHeight;
	}

	public int getLocalX(int globalX) {
		return globalX % chunkWidth;
	}

	public int getLocalY(int globalY) {
		return globalY % chunkHeight;
	}

	public int getGlobalX(int chunkX, int localX) {
		return chunkX * chunkWidth + localX;
	}

	public int getGlobalY(int chunkY, int localY) {
		return chunkY * chunkHeight + localY;
	}

	public T getTile(int globalX, int globalY) {
		int chunkX = getChunkX(globalX);
		int chunkY = getChunkY(globalY);
		int localX = getLocalX(globalX);
		int localY = getLocalY(globalY);
		return getTile(chunkX, chunkY, localX, localY);
	}

	public T getTile(TileCoordinates coordinates) {
		ChunkCoordinates chunk = coordinates.chunkCoordinates;
		return getTile(chunk.x, chunk.y, coordinates.localX, coordinates.localY);
	}

	public T getTile(int chunkX, int chunkY, int localX, int localY) {
		Chunk<T> chunk = getChunk(chunkX, chunkY);
		if (chunk == null) {
			return null;
		}
		return chunk.get(localX, localY);
	}

	public T ensureTile(int globalX, int globalY) {
		Chunk<T> chunk = ensureChunk(getChunkX(globalX), getChunkY(globalY));
		return chunk.ensure(getLocalX(globalX), getLocalY(globalY));
	}
}
