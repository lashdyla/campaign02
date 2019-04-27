package edu.isu.cs.cs3308.structures;

/**
 * Node class needed for the Double List
 *
 * @author Dylan Lasher
 * @param <E> any Node type
 */
public class NodeDouble<E> extends Node<E>
{
	private NodeDouble<E> prev;

	public NodeDouble(E data) {
		super(data);
	}

	/**
	 * Get prev list Node
	 *
	 * @return prev Node
	 */
	public NodeDouble<E> getPrev() {
		return prev;
	}

	/**
	 * Set prev Node
	 *
	 * @param prev Node
	 */
	public void setPrev(NodeDouble<E> prev) {
		this.prev = prev;
	}
}
