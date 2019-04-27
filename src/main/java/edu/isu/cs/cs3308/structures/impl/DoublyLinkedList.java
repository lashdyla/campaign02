package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.NodeDouble;

/**
 * DLL implementation from SLL class
 *
 * @author Dylan Lasher
 * @param <E> any list type
 */
public class DoublyLinkedList<E> extends SinglyLinkedList<E>
{

	/**
	 * Adds list data
	 *
	 * @param dataToAdd in Node
	 * @param atIndex of Node
	 */
	@Override
	protected void nodeSetAdd(E dataToAdd, int atIndex)
	{
		NodeDouble<E> addNode = new NodeDouble<>(dataToAdd);

		if (atIndex == 0)
		{
			if (size > 0)
			{
				addNode.setNext(head);
				((NodeDouble<E>) head).setPrev(addNode);
			}
			head = addNode;
		}
		else if (atIndex >= size)
		{
			tail.setNext(addNode);
			addNode.setPrev((NodeDouble<E>) tail);
			tail = addNode;
		}
		else {
			NodeDouble<E> prevNode = getNode(atIndex-1);
			addNode.setNext(prevNode.getNext());
			addNode.setPrev(prevNode);
			((NodeDouble<E>) addNode.getNext()).setPrev(addNode);
			prevNode.setNext(addNode);
		}
		addSize();
		verifyList();
	}

	/**
	 * Remove List data
	 *
	 * @param atIndex of Node
	 * @return Node data
	 */
	@Override
	protected E nodeSetRemove(int atIndex)
	{
		NodeDouble<E> removeNode = null;

		if (atIndex == 0)
		{
			removeNode = (NodeDouble<E>) head;
			if (size > 1)
			{
				head = removeNode.getNext();
			}
		}
		else if (atIndex >= size - 1)
		{
			NodeDouble<E> prevNode = ((NodeDouble<E>) tail).getPrev();
			removeNode = (NodeDouble<E>) tail;
			tail = prevNode;
		}
		else {
			NodeDouble<E> prevNode = getNode(atIndex-1);
			removeNode = (NodeDouble<E>) prevNode.getNext();
			((NodeDouble<E>) removeNode.getNext()).setPrev(prevNode);
			prevNode.setNext(removeNode.getNext());
		}
		removeNode.setPrev(null);
		removeNode.setNext(null);
		subSize();
		verifyList();

		return removeNode.getData();
	}

	/**
	 * Get specified Node
	 *
	 * @param index in List
	 * @return retrieved Node
	 */
	@Override
	protected NodeDouble<E> getNode(int index)
	{
		NodeDouble<E> seekNode;

		if (index <= size/2)
		{
			seekNode = (NodeDouble<E>) head;
			for (int i = 0; i < index; i++)
			{
				seekNode = (NodeDouble<E>) seekNode.getNext();
			}
		}
		else {
			seekNode = (NodeDouble<E>) tail;
			for (int i = size-1; i > index; i--)
			{
				seekNode = seekNode.getPrev();
			}
		}

		return seekNode;
	}

	/**
	 * For CLL implementation - verification
	 */
	@Override
	protected void verifyBoundary() {
		((NodeDouble<E>) head).setPrev(null);
		tail.setNext(null);
	}
}
