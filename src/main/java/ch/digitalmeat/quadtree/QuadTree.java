package ch.digitalmeat.quadtree;

import java.util.ArrayList;
import java.util.List;

public class QuadTree<Element, Bounds extends Number> {
	private final List<QuadTreeElement<Element, Bounds>> elementSearchResult = new ArrayList<QuadTreeElement<Element, Bounds>>();
	private final List<QuadTreeNode<Element, Bounds>> nodeSearchResult = new ArrayList<QuadTreeNode<Element, Bounds>>();
	public final QuadTreeConfiguration config;
	public final QuadTreeNode<Element, Bounds> root;

	public QuadTree(QuadTreeBounds<Bounds> bounds) {
		this(new QuadTreeConfiguration(), bounds);
	}

	public QuadTree(QuadTreeConfiguration config, QuadTreeBounds<Bounds> bounds) {
		this.config = config;
		root = new QuadTreeNode<Element, Bounds>(this, bounds, 0);
	}

	public QuadTreeBounds<Bounds> getBounds() {
		return root.bounds;
	}

	public List<QuadTreeElement<Element, Bounds>> find(QuadTreeBounds<Bounds> bounds) {
		elementSearchResult.clear();
		root.find(elementSearchResult, bounds);
		return elementSearchResult;
	}

	public QuadTreeElement<Element, Bounds> insert(QuadTreeBounds<Bounds> bounds, Element element) {
		QuadTreeElement<Element, Bounds> elementHost = new QuadTreeElement<Element, Bounds>(bounds, element);
		root.insert(elementHost);
		return elementHost;
	}

	public static class QuadTreeConfiguration {

		/**
		 * The maximum number of levels inside of the tree. -1 for unlimited
		 * levels
		 */
		public final int maxLevels;

		/**
		 * If a node exceeds the split count, child leaves are created and the
		 * objects are moved down in the tree
		 * */
		public final int splitCount;

		public QuadTreeConfiguration() {
			this(10, 10);
		}

		public QuadTreeConfiguration(int maxLevels, int splitCount) {
			this.maxLevels = maxLevels;
			this.splitCount = splitCount;
		}

	}
}
