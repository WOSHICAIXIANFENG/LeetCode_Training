package com.samuel.test;

import java.util.NoSuchElementException;

public interface QueueInterface<E> {
	
	// Puts an element into the queue and returns this interface to allow method chaining.
	QueueInterface<E> add(E element);
	
	// Returns the first element in the queue. Throws an exception if there are no elements in the queue.
	E element() throws NoSuchElementException;
	
	// Remove the first element from the queue. Throws an exception if there are no elements in the queue.
	E remove() throws NoSuchElementException;
	
	// Attempt to add an element to the queue. Returns true if it was successful.
	boolean offer(E element);
	
	// return the first element in the queue. Return null if the queue is empty.
	E peek();
	
	// return the first element and remove it from the queue. Returns null if the queue is empty.
	E poll();
}
