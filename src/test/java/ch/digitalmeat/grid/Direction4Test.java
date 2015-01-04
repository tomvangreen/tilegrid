package ch.digitalmeat.grid;

import static ch.digitalmeat.grid.util.Direction4.Down;
import static ch.digitalmeat.grid.util.Direction4.Left;
import static ch.digitalmeat.grid.util.Direction4.Right;
import static ch.digitalmeat.grid.util.Direction4.Up;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.digitalmeat.grid.util.Direction4;

public class Direction4Test {
	@Test
	public void testGetDirection() {
		System.out.println("Testing Direction4.getDirection");

		executeGetDirectionTest(Right, -44);
		executeGetDirectionTest(Right, -22);
		executeGetDirectionTest(Right, 0);
		executeGetDirectionTest(Right, 22);
		executeGetDirectionTest(Right, 23);

		executeGetDirectionTest(Down, 67);
		executeGetDirectionTest(Down, 68);
		executeGetDirectionTest(Down, 90);
		executeGetDirectionTest(Down, 112);
		executeGetDirectionTest(Down, 113);

		executeGetDirectionTest(Left, 157);
		executeGetDirectionTest(Left, 158);
		executeGetDirectionTest(Left, 180);
		executeGetDirectionTest(Left, 202);
		executeGetDirectionTest(Left, 203);

		executeGetDirectionTest(Up, 247);
		executeGetDirectionTest(Up, 248);
		executeGetDirectionTest(Up, 270);
		executeGetDirectionTest(Up, 292);
		executeGetDirectionTest(Up, 293);

		System.out.println("Completed Testing Direction4.getDirection");
	}

	private void executeGetDirectionTest(Direction4 expected, float angle) {
		System.out.println("  Testing angle: " + angle);
		System.out.println("       Expected: " + expected);
		Direction4 found = Direction4.getDirection(angle);
		System.out.println("          Found: " + found);
		assertEquals(expected, found);
	}
}
