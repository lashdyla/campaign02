package edu.isu.cs.cs3308.structures;

/**
 * An interface for a Queue ADT
 *
 * @author Isaac Griffith
 * @param <E> Element type to be stored in this Queue
 */
public interface Queue<E> {

    /**
     * @return The number of elements in the queue
     */
    int size();

    /**
     * @return tests whether the queue is empty.
     */
    boolean isEmpty();

    /**
     * Inserts an element at the end of the queue.
     *
     * @param element Element to be inserted.
     */
    void offer(E element);

    /**
     * @return The value first element of the queue (with out removing it), or
     * null if empty.
     */
    E peek();

    /**
     * @return The value of the first element of the queue (and removes it), or
     * null if empty.
     */
    E poll();

    /**
     * Prints the contents of the queue starting at top, one item per line. Note
     * this method should not empty the contents of the queue.
     */
    void printQueue();
}
