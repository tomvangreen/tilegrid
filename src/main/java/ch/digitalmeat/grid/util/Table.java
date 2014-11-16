package ch.digitalmeat.grid.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic data structure that wraps a list but provides an easy way to access
 * the list as 2d array.
 */
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
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return -1;
		}
		return x + y * width;
	}

	public T get(int x, int y) {
		return get(index(x, y));
	}

	public T get(int index) {
		if (index < 0 || index >= list.size()) {
			return null;
		}
		return list.get(index);
	}

	public void set(int x, int y, T value) {
		set(index(x, y), value);
	}

	public void set(int index, T value) {
		if (index < 0 || index >= list.size()) {
			return;
		}
		list.set(index, value);
	}

	public int size() {
		return list.size();
	}

	public List<T> getList() {
		return list;
	}
}
