package ch.digitalmeat.grid;

public class Grid<T extends TileBase<T>> {
	public final GridFactory<T> factory;
	public final ChunkManager<T> chunks;
	public final int chunkWidth;
	public final int chunkHeight;

	public Grid(GridFactory<T> factory, int chunkWidth, int chunkHeight) {
		this.factory = factory;
		this.chunkWidth = chunkWidth;
		this.chunkHeight = chunkHeight;
		this.chunks = new ChunkManager<T>(factory, this);
	}

	public Chunk<T> getChunk(int chunkX, int chunkY) {
		return chunks.get(chunkX, chunkY);
	}

	public Chunk<T> ensureChunk(int chunkX, int chunkY) {
		return chunks.ensure(chunkX, chunkY);
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
		Chunk<T> chunk = chunks.get(getChunkX(globalX), getChunkY(globalY));
		if (chunk == null) {
			return null;
		}
		return chunk.get(getLocalX(globalX), getLocalY(globalY));
	}

	public T ensureTile(int globalX, int globalY) {
		Chunk<T> chunk = chunks.ensure(getChunkX(globalX), getChunkY(globalY));
		return chunk.ensure(getLocalX(globalX), getLocalY(globalY));
	}
}
