//package ch.digitalmeat.grid.util;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Map;
//
//import ch.digitalmeat.grid.ChunkGrid;
//import ch.digitalmeat.grid.chunk.ChunkBase;
//import ch.digitalmeat.grid.tile.ChunkTileBase;
//import ch.digitalmeat.util.Point;
//
//public class SimpleTileGridSerializer<T extends ChunkTileBase<T, C>, C extends ChunkBase<T, C>> implements TileGridSerializer<T, C> {
//
//	@Override
//	public ChunkGrid<T, C> readGrid(String gridFile) {
//		return null;
//	}
//
//	@Override
//	public void writeGrid(String path, ChunkGrid<T, C> grid) {
//		try {
//			File file = new File(path + ".grid");
//			File parent = file.getParentFile();
//			if (!parent.exists()) {
//				parent.mkdirs();
//			}
//			FileWriter fileWriter = new FileWriter(file);
//			BufferedWriter writer = new BufferedWriter(fileWriter);
//			writeGrid(grid, writer, path);
//			writer.close();
//			fileWriter.close();
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//	}
//
//	private void writeGrid(ChunkGrid<T, C> grid, BufferedWriter writer, String path) throws IOException {
//		writer.write("chunksize:" + grid.chunkWidth + ";" + grid.chunkHeight);
//		writer.write("\n");
//		Map<Point, C> chunks = grid.chunks;
//		writer.write("chunks:" + grid.chunkWidth + ";" + grid.chunkHeight);
//		writer.write("\n");
//
//		for (Point coordinates : chunks.keySet()) {
//
//			C chunk = chunks.get(coordinates);
//			String name = coordinates.x + "." + coordinates.y;
//			writer.write(name);
//			writer.write("\n");
//
//			writeChunk(path + "." + name, chunk);
//		}
//	}
//
//	@Override
//	public C readChunk(String chunkFile) {
//		return null;
//	}
//
//	@Override
//	public void writeChunk(String path, C chunk) {
//		try {
//			File file = new File(path);
//			File parent = file.getParentFile();
//			if (!parent.exists()) {
//				parent.mkdirs();
//			}
//			FileWriter fileWriter = new FileWriter(file);
//			BufferedWriter writer = new BufferedWriter(fileWriter);
//			writeChunk(chunk, writer, path);
//			writer.close();
//			fileWriter.close();
//
//		} catch (Exception ex) {
//			throw new RuntimeException();
//		}
//	}
//
//	private void writeChunk(C chunk, BufferedWriter writer, String path) throws IOException {
//		for (int y = chunk.grid.chunkHeight - 1; y >= 0; y--) {
//			for (int x = 0; x < chunk.grid.chunkWidth; x++) {
//				T tile = chunk.get(x, y);
//				if (tile == null) {
//					writer.write("!");
//				} else {
//					writer.write("T");
//				}
//			}
//			writer.write("\n");
//		}
//	}
// }
