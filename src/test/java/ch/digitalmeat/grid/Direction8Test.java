package ch.digitalmeat.grid;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.digitalmeat.grid.util.Direction8;

public class Direction8Test {

	@Test
	public void testLeft() {
		assertEquals(Direction8.UpLeft, Direction8.Up.left());
		assertEquals(Direction8.Left, Direction8.UpLeft.left());
		assertEquals(Direction8.DownLeft, Direction8.Left.left());
		assertEquals(Direction8.Down, Direction8.DownLeft.left());
		assertEquals(Direction8.DownRight, Direction8.Down.left());
		assertEquals(Direction8.Right, Direction8.DownRight.left());
		assertEquals(Direction8.UpRight, Direction8.Right.left());
		assertEquals(Direction8.Up, Direction8.UpRight.left());
	}

	@Test
	public void testRight() {
		assertEquals(Direction8.UpLeft.right(), Direction8.Up);
		assertEquals(Direction8.Left.right(), Direction8.UpLeft);
		assertEquals(Direction8.DownLeft.right(), Direction8.Left);
		assertEquals(Direction8.Down.right(), Direction8.DownLeft);
		assertEquals(Direction8.DownRight.right(), Direction8.Down);
		assertEquals(Direction8.Right.right(), Direction8.DownRight);
		assertEquals(Direction8.UpRight.right(), Direction8.Right);
		assertEquals(Direction8.Up.right(), Direction8.UpRight);
	}

	@Test
	public void testOpposite() {
		assertEquals(Direction8.UpLeft.opposite(), Direction8.DownRight);
		assertEquals(Direction8.Left.opposite(), Direction8.Right);
		assertEquals(Direction8.DownLeft.opposite(), Direction8.UpRight);
		assertEquals(Direction8.Down.opposite(), Direction8.Up);
		assertEquals(Direction8.DownRight.opposite(), Direction8.UpLeft);
		assertEquals(Direction8.Right.opposite(), Direction8.Left);
		assertEquals(Direction8.UpRight.opposite(), Direction8.DownLeft);
		assertEquals(Direction8.Up.opposite(), Direction8.Down);
	}

	@Test
	public void stepXTest() {
		assertEquals(0, Direction8.Up.stepX());
		assertEquals(-1, Direction8.UpLeft.stepX());
		assertEquals(-1, Direction8.Left.stepX());
		assertEquals(-1, Direction8.DownLeft.stepX());
		assertEquals(0, Direction8.Down.stepX());
		assertEquals(1, Direction8.DownRight.stepX());
		assertEquals(1, Direction8.Right.stepX());
		assertEquals(1, Direction8.UpRight.stepX());
	}

	@Test
	public void stepYTest() {
		assertEquals(1, Direction8.Up.stepY());
		assertEquals(1, Direction8.UpLeft.stepY());
		assertEquals(0, Direction8.Left.stepY());
		assertEquals(-1, Direction8.DownLeft.stepY());
		assertEquals(-1, Direction8.Down.stepY());
		assertEquals(-1, Direction8.DownRight.stepY());
		assertEquals(0, Direction8.Right.stepY());
		assertEquals(1, Direction8.UpRight.stepY());
	}
}
