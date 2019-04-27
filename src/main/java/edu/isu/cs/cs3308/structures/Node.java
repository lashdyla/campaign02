package edu.isu.cs.cs3308.structures;

/**
 * Node class for list implementation
 *
 * @author Dylan Lasher
 * @param <E> any node type
 */
public class Node<E>
{

	protected E data;
	protected Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	/**
	 * Get stored Node data
	 *
	 * @return stored Node data
	 */
	public E getData() {
		return data;
	}

	/**
	 * Set stored Node data
	 *
	 * @param data stored in Node
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Get next ref-ed Node
	 *
	 * @return next Node
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Set Node as next in List
	 *
	 * @param next Node
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
