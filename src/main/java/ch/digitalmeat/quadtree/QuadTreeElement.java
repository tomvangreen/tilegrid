package ch.digitalmeat.quadtree;

public class QuadTreeElement<ElementType, BoundsType extends Number> {
	public final QuadTreeBounds<BoundsType> bounds;
	public final ElementType element;

	public QuadTreeElement(QuadTreeBounds<BoundsType> bounds, ElementType element) {
		this.bounds = bounds;
		this.element = element;
	}
}
