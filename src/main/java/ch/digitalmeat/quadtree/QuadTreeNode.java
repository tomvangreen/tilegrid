package ch.digitalmeat.quadtree;

import java.util.ArrayList;
import java.util.List;

public class QuadTreeNode<E, B extends Number> {

	public final QuadTree<E, B> tree;
	public final QuadTreeBounds<B> bounds;
	public final List<QuadTreeNode<E, B>> children = new ArrayList<QuadTreeNode<E, B>>();
	public final List<QuadTreeElement<E, B>> elements = new ArrayList<QuadTreeElement<E, B>>();
	public final int level;
	private final List<QuadTreeBounds<B>> childBounds = new ArrayList<QuadTreeBounds<B>>();

	public boolean isLeaf;

	public QuadTreeNode(QuadTree<E, B> tree, QuadTreeBounds<B> bounds, int level) {
		this.tree = tree;
		this.bounds = bounds;
		this.level = level;
		isLeaf = true;
		children.add(null);
		children.add(null);
		children.add(null);
		children.add(null);
	}

	public void find(List<QuadTreeElement<E, B>> resultList, QuadTreeBounds<B> searchBounds) {
		if (this.bounds.intersects(searchBounds)) {
			if (isLeaf) {
				for (QuadTreeElement<E, B> element : elements) {
					if (element.bounds.intersects(searchBounds)) {
						resultList.add(element);
					}
				}
			} else {
				for (QuadTreeNode<E, B> child : children) {
					child.find(resultList, searchBounds);
				}
			}
		}
	}

	public QuadTreeBounds<B> getSubQuadrant(Quadrant quadrant) {
		ensureChildQuadrants();
		return childBounds.get(quadrant.index);
	}

	private void ensureChildQuadrants() {
		if (childBounds.size() == 0) {
			for (Quadrant quadrant : Quadrant.values()) {
				childBounds.add(bounds.getSubBounds(quadrant));
			}
		}
	}

	public void insert(QuadTreeElement<E, B> element) {
		if (isLeaf) {
			elements.add(element);
			if (elements.size() > tree.config.splitCount) {
				int maxLevels = tree.config.maxLevels;
				if (maxLevels == -1 || maxLevels > level) {
					createChildLeaves();
					moveChildrenDown();
				}
			}
		} else {
			for (QuadTreeNode<E, B> child : children) {
				if (child.bounds.intersects(element.bounds)) {
					child.insert(element);
				}
			}
		}
	}

	private void moveChildrenDown() {
		for (QuadTreeElement<E, B> element : elements) {
			insert(element);
		}
		elements.clear();
	}

	public void createChildLeaves() {
		for (Quadrant quadrant : Quadrant.values()) {
			QuadTreeBounds<B> quadrantBounds = getSubQuadrant(quadrant);
			QuadTreeNode<E, B> childNode = new QuadTreeNode<E, B>(tree, quadrantBounds, level + 1);
			children.set(quadrant.index, childNode);
		}
		isLeaf = false;
	}
}
