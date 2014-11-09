package ch.digitalmeat.grid;

import java.util.HashMap;
import java.util.Map;

import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.chunk.ChunkCoordinates;
import ch.digitalmeat.grid.tile.TileBase;
import ch.digitalmeat.grid.tile.TileCoordinates;

public class TileGrid<T extends TileBase<T, C>, C extends ChunkBase<T, C>> {
	public final TileGridFactory<T, C> factory;
	public final int chunkWidth;
	public final int chunkHeight;
	private final ChunkCoordinates finderCoordinates = new ChunkCoordinates();
	public final Map<ChunkCoordinates, C> chunks = new HashMap<ChunkCoordinates, C>();

	public TileGrid(TileGridFactory<T, C> factory, int chunkWidth, int chunkHeight) {
		this.factory = factory;
		this.chunkWidth = chunkWidth;
		this.chunkHeight = chunkHeight;
	}

	public C getChunk(int chunkX, int chunkY) {
		finderCoordinates.set(chunkX, chunkY);
		return getChunk(finderCoordinates);
	}

	public C getChunk(ChunkCoordinates coordinates) {
		return chunks.get(coordinates);
	}

	public C ensureChunk(int chunkX, int chunkY) {
		finderCoordinates.set(chunkX, chunkY);
		return ensureChunk(finderCoordinates);
	}

	public C ensureChunk(ChunkCoordinates coordinates) {
		C chunk = chunks.get(coordinates);
		if (chunk == null) {
			chunk = factory.createChunk();
			chunk.coordinates.set(coordinates.x, coordinates.y);
			chunk.init(chunkWidth, chunkHeight);
			chunk.grid = this;
			chunks.put(chunk.coordinates, chunk);
		}
		return chunk;
	}

	public int getChunkX(long globalX) {
		return (int) (globalX / chunkWidth);
	}

	public int getChunkY(long globalY) {
		return (int) (globalY / chunkHeight);
	}

	public int getLocalX(long globalX) {
		return (int) (globalX % chunkWidth);
	}

	public int getLocalY(long globalY) {
		return (int) (globalY % chunkHeight);
	}

	public int getGlobalX(int chunkX, int localX) {
		return chunkX * chunkWidth + localX;
	}

	public int getGlobalY(int chunkY, int localY) {
		return chunkY * chunkHeight + localY;
	}

	public T getTile(long globalX, long globalY) {
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
		C chunk = getChunk(chunkX, chunkY);
		if (chunk == null) {
			return null;
		}
		return chunk.get(localX, localY);
	}

	public T ensureTile(int globalX, int globalY) {
		C chunk = ensureChunk(getChunkX(globalX), getChunkY(globalY));
		return chunk.ensure(getLocalX(globalX), getLocalY(globalY));
	}
}
