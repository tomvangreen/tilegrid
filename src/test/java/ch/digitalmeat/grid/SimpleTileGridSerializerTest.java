//package ch.digitalmeat.grid;
//
//import org.junit.Test;
//
//import ch.digitalmeat.grid.util.SimpleTileGridSerializer;
//
//public class SimpleTileGridSerializerTest {
//
//	private static final String TESTFOLDER = "testdata/";
//
//	@Test
//	public void testOutput() {
//		SimpleTileGridSerializer<TestTile, TestChunk> serializer = new SimpleTileGridSerializer<TestTile, TestChunk>();
//		ChunkGrid<TestTile, TestChunk> grid = new ChunkGrid<TestTile, TestChunk>(new TestFactory(), 32, 32);
//		grid.ensureTile(1, 1);
//		serializer.writeGrid(TESTFOLDER + "testOutput", grid);
//	}
//
// }
