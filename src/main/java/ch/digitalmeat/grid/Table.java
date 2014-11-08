package ch.digitalmeat.grid;

import java.util.ArrayList;
import java.util.List;

public class Table<T> {
	private final List<T> list = new ArrayList<T>();
	public final int width;
	public final int height;

	public Table(int width, int height) {
		assert width > 0;
		assert height > 0;
		this.width = width;
		this.height = height;
		int count = width * height;
		while (count-- > 0) {
			list.add(null);
		}
	}

	public int index(int x, int y) {
		return x + y * height;
	}

	public T get(int x, int y) {
		return list.get(index(x, y));
	}

	public void set(int x, int y, T value) {
		list.set(index(x, y), value);
	}
}
