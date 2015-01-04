package ch.digitalmeat.grid;

import static ch.digitalmeat.grid.util.Direction8.Down;
import static ch.digitalmeat.grid.util.Direction8.DownLeft;
import static ch.digitalmeat.grid.util.Direction8.DownRight;
import static ch.digitalmeat.grid.util.Direction8.Left;
import static ch.digitalmeat.grid.util.Direction8.Right;
import static ch.digitalmeat.grid.util.Direction8.Up;
import static ch.digitalmeat.grid.util.Direction8.UpLeft;
import static ch.digitalmeat.grid.util.Direction8.UpRight;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.digitalmeat.grid.util.Direction8;

public class Direction8Test {

	@Test
	public void testLeft() {
		assertEquals(UpLeft, Up.left());
		assertEquals(Left, UpLeft.left());
		assertEquals(DownLeft, Left.left());
		assertEquals(Down, DownLeft.left());
		assertEquals(DownRight, Down.left());
		assertEquals(Right, DownRight.left());
		assertEquals(UpRight, Right.left());
		assertEquals(Up, UpRight.left());
	}

	@Test
	public void testRight() {
		assertEquals(UpLeft.right(), Up);
		assertEquals(Left.right(), UpLeft);
		assertEquals(DownLeft.right(), Left);
		assertEquals(Down.right(), DownLeft);
		assertEquals(DownRight.right(), Down);
		assertEquals(Right.right(), DownRight);
		assertEquals(UpRight.right(), Right);
		assertEquals(Up.right(), UpRight);
	}

	@Test
	public void testOpposite() {
		assertEquals(UpLeft.opposite(), DownRight);
		assertEquals(Left.opposite(), Right);
		assertEquals(DownLeft.opposite(), UpRight);
		assertEquals(Down.opposite(), Up);
		assertEquals(DownRight.opposite(), UpLeft);
		assertEquals(Right.opposite(), Left);
		assertEquals(UpRight.opposite(), DownLeft);
		assertEquals(Up.opposite(), Down);
	}

	@Test
	public void stepXTest() {
		assertEquals(0, Up.stepX());
		assertEquals(-1, UpLeft.stepX());
		assertEquals(-1, Left.stepX());
		assertEquals(-1, DownLeft.stepX());
		assertEquals(0, Down.stepX());
		assertEquals(1, DownRight.stepX());
		assertEquals(1, Right.stepX());
		assertEquals(1, UpRight.stepX());
	}

	@Test
	public void stepYTest() {
		assertEquals(1, Up.stepY());
		assertEquals(1, UpLeft.stepY());
		assertEquals(0, Left.stepY());
		assertEquals(-1, DownLeft.stepY());
		assertEquals(-1, Down.stepY());
		assertEquals(-1, DownRight.stepY());
		assertEquals(0, Right.stepY());
		assertEquals(1, UpRight.stepY());
	}

	@Test
	public void testGetDirection() {
		System.out.println("Testing Direction8.getDirection");

		executeGetDirectionTest(Right, 22);
		executeGetDirectionTest(Right, 0);
		executeGetDirectionTest(Right, -22);

		executeGetDirectionTest(DownRight, -23);
		executeGetDirectionTest(DownRight, -45);
		executeGetDirectionTest(DownRight, -67);

		executeGetDirectionTest(Down, -68);
		executeGetDirectionTest(Down, -90);
		executeGetDirectionTest(Down, -112);

		executeGetDirectionTest(DownLeft, -113);
		executeGetDirectionTest(DownLeft, -135);
		executeGetDirectionTest(DownLeft, -157);

		executeGetDirectionTest(Left, -158);
		executeGetDirectionTest(Left, -180);
		executeGetDirectionTest(Left, -202);

		executeGetDirectionTest(UpLeft, -203);
		executeGetDirectionTest(UpLeft, -225);
		executeGetDirectionTest(UpLeft, -247);

		executeGetDirectionTest(Up, -248);
		executeGetDirectionTest(Up, -270);
		executeGetDirectionTest(Up, -292);

		System.out.println("Completed Testing Direction8.getDirection");
	}

	private void executeGetDirectionTest(Direction8 expected, float angle) {
		System.out.println("  Testing angle: " + angle);
		System.out.println("       Expected: " + expected);
		Direction8 found = Direction8.getDirection(angle);
		System.out.println("          Found: " + found);
		assertEquals(expected, found);
	}
}
