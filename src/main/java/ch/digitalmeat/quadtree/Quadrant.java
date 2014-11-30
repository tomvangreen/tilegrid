package ch.digitalmeat.quadtree;

public enum Quadrant {
	SouthWest(0), SouthEast(1), NorthEasts(2), NorthWest(3);

	public final int index;

	Quadrant(int index) {
		this.index = index;
	}
}
