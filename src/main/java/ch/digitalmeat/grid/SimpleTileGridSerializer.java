package ch.digitalmeat.grid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SimpleTileGridSerializer<T extends TileBase<T>> implements TileGridSerializer<T> {

	@Override
	public TileGrid<T> readGrid(String gridFile) {
		return null;
	}

	@Override
	public void writeGrid(String path, TileGrid<T> grid) {
		try {
			File file = new File(path + ".grid");
			File parent = file.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writeGrid(grid, writer, path);
			writer.close();
			fileWriter.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void writeGrid(TileGrid<T> grid, BufferedWriter writer, String path) throws IOException {
		writer.write("chunksize:" + grid.chunkWidth + ";" + grid.chunkHeight);
		writer.write("\n");
		Map<ChunkCoordinates, Chunk<T>> chunks = grid.chunks;
		writer.write("chunks:" + grid.chunkWidth + ";" + grid.chunkHeight);
		writer.write("\n");

		for (ChunkCoordinates coordinates : chunks.keySet()) {

			Chunk<T> chunk = chunks.get(coordinates);
			String name = coordinates.x + "." + coordinates.y;
			writer.write(name);
			writer.write("\n");

			writeChunk(path + "." + name, chunk);
		}
	}

	@Override
	public Chunk<T> readChunk(String chunkFile) {
		return null;
	}

	@Override
	public void writeChunk(String path, Chunk<T> chunk) {
		try {
			File file = new File(path);
			File parent = file.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writeChunk(chunk, writer, path);
			writer.close();
			fileWriter.close();

		} catch (Exception ex) {
			throw new RuntimeException();
		}
	}

	private void writeChunk(Chunk<T> chunk, BufferedWriter writer, String path) throws IOException {
		for (int y = chunk.grid.chunkHeight - 1; y >= 0; y--) {
			for (int x = 0; x < chunk.grid.chunkWidth; x++) {
				T tile = chunk.get(x, y);
				if (tile == null) {
					writer.write("!");
				} else {
					writer.write("T");
				}
			}
			writer.write("\n");
		}
	}
}
