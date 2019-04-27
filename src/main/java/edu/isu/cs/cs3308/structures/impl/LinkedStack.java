package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

/**
 * Stack-based linked stack implementation
 *
 * @author Dylan Lasher
 * @param <E> any stack type
 */
public class LinkedStack<E> implements Stack<E>
{
	DoublyLinkedList<E> theList = new DoublyLinkedList<>();

	/**
	 * Add new stack element at start
	 *
	 * @param element data being added
	 */
	@Override
	public void push(E element) {
		theList.addFirst(element);
	}

	/**
	 * Check value at start without removal
	 *
	 * @return value at stack start
	 */
	@Override
	public E peek() {
		return theList.first();
	}

	/**
	 * Remove stack beginning value
	 *
	 * @return stack beginning value
	 */
	@Override
	public E pop() {
		return theList.removeFirst();
	}

	/**
	 * Count stack elements
	 *
	 * @return Number of stack elements
	 */
	@Override
	public int size() {
		return theList.size();
	}

	/**
	 * Check if empty stack
	 *
	 * @return True if empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	/**
	 * Send data to other stack in reverse order
	 *
	 * @param to stack being transferred
	 */
	@Override
	public void transfer(Stack<E> to)
	{
		if (to != null && this.size() > 0)
		{
			while(this.size() > 0)
			{
				to.push(this.pop());
			}
		}
	}

	/**
	 * Reverse stack order
	 */
	@Override
	public void reverse()
	{
		LinkedStack<E> temp1 = new LinkedStack<>();
		LinkedStack<E> temp2 = new LinkedStack<>();

		this.transfer(temp1);
		temp1.transfer(temp2);
		temp2.transfer(this);
	}

	/**
	 * Add stack to end of other stack
	 *
	 * @param other stack conent being added
	 */
	@Override
	public void merge(Stack<E> other)
	{
		if (other != null)
		{
			LinkedStack<E> origCopy = new LinkedStack<>();
			LinkedStack<E> otherCopy = new LinkedStack<>();

			this.transfer(origCopy);
			other.transfer(otherCopy);

			while (otherCopy.size() > 0)
			{
				E tempElem = otherCopy.pop();
				other.push(tempElem);
				this.push(tempElem);
			}

			origCopy.transfer(this);
		}
	}

	/**
	 * Print stack contents
	 */
	@Override
	public void printStack() {
		theList.printList();
	}
}
