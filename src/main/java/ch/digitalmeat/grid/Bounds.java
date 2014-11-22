package ch.digitalmeat.grid;

public class Bounds {
	public int x;
	public int y;
	public int width;
	public int height;

	public int x2() {
		return x + width;
	}

	public int y2() {
		return y + height;
	}

	public void set(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
}
