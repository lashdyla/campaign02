package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;

/**
 * Queue-implemented linked queue
 *
 * @author Dylan Lasher
 * @param <E> any queue type
 */
public class LinkedQueue<E> implements Queue<E>
{
	protected DoublyLinkedList<E> theList = new DoublyLinkedList<>();

	/**
	 * Add new queue element to end
	 *
	 * @param element data added
	 */
	@Override
	public void offer(E element) {
		theList.addLast(element);
	}

	/**
	 * Remove value at start of queue
	 *
	 * @return value at start of queue
	 */
	@Override
	public E poll() {
		return theList.removeFirst();
	}

	/**
	 * Check value at start of queue - without removal
	 *
	 * @return value at start of queue
	 */
	@Override
	public E peek() {
		return theList.first();
	}

	/**
	 * Check size of queue
	 *
	 * @return size of queue
	 */
	@Override
	public int size() {
		return theList.size();
	}

	/**
	 * Check if empty queue
	 *
	 * @return True if empty queue, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	/**
	 * Print queue contents
	 */
	@Override
	public void printQueue() {
		theList.printList();
	}
}
