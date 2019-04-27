package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node;

/**
 * SLL implementation - derived from List class
 *
 * @author Dylan Lasher
 * @param <E> any list type
 */
public class SinglyLinkedList<E> implements List<E>
{
	protected Node<E> head = null;
	protected Node<E> tail = null;
	protected Node<E> tempNode = null;
	protected int size = 0;

	/**
	 * Check if null element
	 */
	protected boolean checkElement(E element) {
		return element != null;
	}

	/**
	 * Check if index inside index range
	 *
	 * @param index being checked
	 * @return True if index in range, false otherwise
	 */
	protected boolean checkIndex(int index) {
		return index < size && index >= 0;
	}

	protected void verifyList()
	{
		if (size == 1)
		{
			if (head != null)
			{
				tail = head;
			}
			else {
				head = tail;
			}
		}

		if (size == 0)
		{
			head = null;
			tail = null;
		}

		if (size > 0)
		{
			verifyBoundary();
		}
	}

	protected void nodeSetAdd(E dataToAdd, int atIndex)
	{
		Node<E> addNode = new Node<>(dataToAdd);

		if (atIndex == 0)
		{
			if (size > 0)
			{
				addNode.setNext(head);
			}
			head = addNode;
		}
		else if (atIndex >= size)
		{
			tail.setNext(addNode);
			tail = addNode;
		}
		else {
			Node<E> prevNode = getNode(atIndex-1);
			addNode.setNext(prevNode.getNext());
			prevNode.setNext(addNode);
		}
		addSize();
		verifyList();
	}

	protected E nodeSetRemove(int atIndex)
	{
		Node<E> removeNode = null;

		if (atIndex == 0)
		{
			removeNode = head;
			if (size > 1)
			{
				head = removeNode.getNext();
			}
		}
		else {
			Node<E> prevNode = getNode(atIndex-1);
			removeNode = prevNode.getNext();
			prevNode.setNext(removeNode.getNext());
			if (atIndex >= size-1)
			{
				tail = prevNode;
			}
		}
		removeNode.setNext(null);
		subSize();
		verifyList();

		return removeNode.getData();
	}

	/**
	 * Get Node at specified index
	 *
	 * @param index for List
	 * @return retrieved Node
	 */
	protected Node<E> getNode(int index)
	{
		Node<E> seekNode = head;

		for (int i = 0; i < index; i++)
		{
			seekNode = seekNode.getNext();
		}

		return seekNode;
	}

	/**
	 * Increment List size
	 */
	protected void addSize() {
		size++;
	}

	/**
	 * Decrement List size
	 */
	protected void subSize()
	{
		size--;

		if (size < 0)
		{
			size = 0;
		}
	}

	protected void verifyBoundary() {
		tail.setNext(null);
	}

	/**
	 * Get data from first Node
	 */
	@Override
	public E first() {
		return (head != null) ? head.getData() : null;
	}

	/**
	 * Get data from last Node
	 */
	@Override
	public E last() {
		return (tail != null) ? tail.getData() : null;
	}

	/**
	 * Create end Node
	 */
	@Override
	public void addLast(E element)
	{
		if (checkElement(element))
		{
			if (!isEmpty())
			{
				nodeSetAdd(element,size);
			}
			else {
				addFirst(element);
			}
		}
	}

	/**
	 * Create start Node
	 */
	@Override
	public void addFirst(E element)
	{
		if (checkElement(element))
		{
			nodeSetAdd(element, 0);
		}
	}

	/**
	 * Remove first list Node
	 */
	@Override
	public E removeFirst()
	{
		if (head != null)
		{
			return nodeSetRemove(0);
		}
		else {
			return null;
		}
	}

	/**
	 * Remove end list Node
	 */
	@Override
	public E removeLast()
	{
		if (size > 1)
		{
			return remove(size - 1);
		}
		else {
			return removeFirst();
		}
	}

	/**
	 * Create Node at specified index
	 */
	@Override
	public void insert(E element, int index)
	{
		if (checkElement(element))
		{
			if (index >= 0)
			{
				if (index == 0)
				{
					addFirst(element);
				}
				else if (index >= size)
				{
					addLast(element);
				}
				else {
					nodeSetAdd(element, index);
				}
			}
		}
	}

	/**
	 * Remove Node st specified index
	 */
	@Override
	public E remove(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return removeFirst();
			}
			else {
				return nodeSetRemove(index);
			}
		}
		else {
			return null;
		}
	}

	/**
	 * Retrieve Node data at specified index
	 */
	@Override
	public E get(int index)
	{
		if (checkIndex(index))
		{
			if (index == 0)
			{
				return head.getData();
			}
			else if (index == size-1)
			{
				return tail.getData();
			}
			else {
				return getNode(index).getData();
			}
		}
		else {
			return null;
		}
	}

	/**
	 * Retrieve list size
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Check if empty list
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Print contents
	 */
	@Override
	public void printList()
	{
		if (!isEmpty())
		{
			tempNode = head;

			for (int i = 0; i < size; i++)
			{
				if (i < size-1)
				{
					System.out.print(tempNode.getData() + "\n");
				}
				else {
					System.out.println(tempNode.getData());
				}
				tempNode = tempNode.getNext();
			}
		}
		else {
			System.out.println("There is nothing in this list.");
		}
		tempNode = null;
	}
}