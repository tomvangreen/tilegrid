package ch.digitalmeat.grid;

import java.util.ArrayList;
import java.util.List;

import ch.digitalmeat.grid.chunk.ChunkBase;
import ch.digitalmeat.grid.tile.ChunkTileBase;
import ch.digitalmeat.grid.util.Coordinates;

public class BoundsSelector<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> implements Selector<T> {

	private final Coordinates coordinates = new Coordinates();
	private final List<T> results = new ArrayList<T>();
	private final ChunkGrid<T, C> grid;

	public BoundsSelector(ChunkGrid<T, C> grid) {
		this.grid = grid;
	}

	@Override
	public List<T> select(Bounds bounds, boolean ensureTiles) {
		return select(bounds.x, bounds.y, bounds.x2(), bounds.y2(), ensureTiles);
	}

	@Override
	public List<T> select(int x, int y, int x2, int y2, boolean ensureTiles) {
		results.clear();
		if (grid != null) {
			int lowX = Math.min(x, x2);
			int highX = Math.max(x, x2);
			int lowY = Math.min(y, y2);
			int highY = Math.max(y, y2);
			int lowChunkX = grid.getChunkX(lowX);
			int highChunkX = grid.getChunkX(highX);
			int lowChunkY = grid.getChunkY(lowY);
			int highChunkY = grid.getChunkY(highY);
			for (int chunkY = lowChunkY; chunkY <= highChunkY; chunkY++) {
				for (int chunkX = lowChunkX; chunkX <= highChunkX; chunkX++) {
					coordinates.set(chunkX, chunkY);
					C chunk = ensureTiles ? grid.ensureChunk(coordinates) : grid.getChunk(coordinates);
					if (chunk != null) {
						int localStartX = (chunkX == lowChunkX) ? grid.getLocalX(lowX) : 0;
						int localStartY = (chunkY == lowChunkY) ? grid.getLocalY(lowY) : 0;
						int localEndX = (chunkX == highChunkX) ? grid.getLocalX(highX) : grid.chunkWidth - 1;
						int localEndY = (chunkY == highChunkY) ? grid.getLocalY(highY) : grid.chunkHeight - 1;
						for (int localY = localStartY; localY <= localEndY; localY++) {
							for (int localX = localStartX; localX <= localEndX; localX++) {
								T tile = ensureTiles ? chunk.ensure(localX, localY) : chunk.get(localX, localY);
								if (tile != null) {
									results.add(tile);
								}
							}
						}
					}
				}
			}

		}
		return results;
	}
}
