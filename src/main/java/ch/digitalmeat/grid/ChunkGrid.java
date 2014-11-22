package ch.digitalmeat.grid;

import java.util.HashMap;
import java.util.Map;

import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.tile.ChunkTileBase;
import ch.digitalmeat.grid.util.Coordinates;

public class ChunkGrid<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> {
	public final ChunkGridFactory<T, C> factory;
	public final int chunkWidth;
	public final int chunkHeight;
	private final Coordinates finderCoordinates = new Coordinates();
	public final Map<Coordinates, C> chunks = new HashMap<Coordinates, C>();
	public final ChunkGridNavigator<T, C> navigator = new ChunkGridNavigator<T, C>(this);
	public final BoundsSelector<T, C> selector = new BoundsSelector(this);

	public ChunkGrid(ChunkGridFactory<T, C> factory, int chunkWidth, int chunkHeight) {
		this.factory = factory;
		this.chunkWidth = chunkWidth;
		this.chunkHeight = chunkHeight;
	}

	public C getChunk(int chunkX, int chunkY) {
		finderCoordinates.set(chunkX, chunkY);
		return getChunk(finderCoordinates);
	}

	public C getChunk(Coordinates coordinates) {
		return chunks.get(coordinates);
	}

	public C ensureChunk(int chunkX, int chunkY) {
		finderCoordinates.set(chunkX, chunkY);
		return ensureChunk(finderCoordinates);
	}

	public C ensureChunk(Coordinates coordinates) {
		C chunk = chunks.get(coordinates);
		if (chunk == null) {
			chunk = factory.createChunk();
			chunk.coordinates.set(coordinates.x, coordinates.y);
			chunk.init(coordinates.x, coordinates.y, chunkWidth, chunkHeight);
			chunk.grid = this;
			chunks.put(chunk.coordinates, chunk);
		}
		return chunk;
	}

	// TODO: Ultra ugly so far
	public int getChunkX(int globalX) {
		return ((globalX + (globalX < 0 ? 1 : 0)) / chunkWidth) - (globalX < 0 ? 1 : 0);
	}

	public int getChunkY(int globalY) {
		return ((globalY + (globalY < 0 ? 1 : 0)) / chunkWidth) - (globalY < 0 ? 1 : 0);
	}

	public int getLocalX(int globalX) {
		if (globalX >= 0) {
			return globalX % chunkWidth;
		}
		return (chunkWidth + (globalX % chunkWidth)) % chunkWidth;
	}

	public int getLocalY(int globalY) {
		if (globalY >= 0) {
			return globalY % chunkHeight;
		}
		return (chunkHeight + (globalY % chunkHeight)) % chunkHeight;
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

	public T getTile(Coordinates coordinates) {
		int chunkX = getChunkX(coordinates.x);
		int chunkY = getChunkY(coordinates.y);
		return getTile(chunkX, chunkY, coordinates.x, coordinates.y);
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
		return chunk.ensure(globalX, globalY);
	}
}
