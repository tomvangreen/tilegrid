package ch.digitalmeat.util;

import java.util.ArrayList;
import java.util.List;

public class Raycast {
	private final List<Point> results = new ArrayList<Point>();

	public List<Point> cast(int x, int y, int x2, int y2) {
		results.clear();
		int w = x2 - x;
		int h = y2 - y;
		int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
		if (w < 0) {
			dx1 = -1;
		} else if (w > 0) {
			dx1 = 1;
		}
		if (h < 0) {
			dy1 = -1;
		} else if (h > 0) {
			dy1 = 1;
		}
		if (w < 0) {
			dx2 = -1;
		} else if (w > 0) {
			dx2 = 1;
		}
		int longest = Math.abs(w);
		int shortest = Math.abs(h);
		if (!(longest > shortest)) {
			longest = Math.abs(h);
			shortest = Math.abs(w);
			if (h < 0) {
				dy2 = -1;
			} else if (h > 0) {
				dy2 = 1;
			}
			dx2 = 0;
		}
		int numerator = longest >> 1;
		for (int i = 0; i <= longest; i++) {
			results.add(new Point(x, y));
			numerator += shortest;
			if (!(numerator < longest)) {
				numerator -= longest;
				x += dx1;
				y += dy1;
			} else {
				x += dx2;
				y += dy2;
			}
		}
		return results;
	}

	public List<Point> castConnecting(int x, int y, int x2, int y2) {
		results.clear();
		int dx = Math.abs(x2 - x);
		int dy = Math.abs(y2 - y);
		int sgnX = x < x2 ? 1 : -1;
		int sgnY = y < y2 ? 1 : -1;
		int e = 0;
		for (int i = 0; i <= dx + dy; i++) {
			results.add(new Point(x, y));
			int e1 = e + dy;
			int e2 = e - dx;
			if (Math.abs(e1) < Math.abs(e2)) {
				x += sgnX;
				e = e1;
			} else {
				y += sgnY;
				e = e2;
			}
		}
		return results;
	}

}
