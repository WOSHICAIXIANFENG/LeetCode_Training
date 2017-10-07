package com.samuel.test;

import java.util.NoSuchElementException;

public class GenericArrayQueue<E> implements QueueInterface<E> {
	public static final int DEFAULT_INITIAL_ARRAY_SIZE = 5;
	// set to prevent OutOfMemoryErrors
	public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private E[] data;
	private int front, size, back;
	
	public GenericArrayQueue() {
		this(DEFAULT_INITIAL_ARRAY_SIZE);
	}
	
	public GenericArrayQueue(int capacity) throws IllegalArgumentException {
		if (capacity < 1) {
			throw new IllegalArgumentException("Queue capacity must be 1 or greater");
		}
		
		if (capacity > MAX_ARRAY_SIZE) {
			throw new IllegalArgumentException("Stack capacity is greater than maximum array size");
		}
		
		@SuppressWarnings("unchecked")
		E[] tempData = (E[]) new Object[capacity];
		data = tempData;
	}
	
	@Override
	public QueueInterface<E> add(E element) throws IllegalArgumentException {
		if (size >= data.length) {
			throw new IllegalArgumentException("Run out of memory to queue");
		}
		
		data[back] = element;
		back ++;
		size ++;
		return this;
	}

	@Override
	public E element() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException("Queue does not contain any items");
		}
		
		return data[front];
	}

	@Override
	public E remove() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException("Queue does not contain any items");
		}
		size --;
		E output = data[front];
		data[front] = null;
		front++;
		return output;
	}

	@Override
	public boolean offer(E element) {
		if (size >= data.length) {
			return false;
		}
		size ++;
		data[back] = element;
		back ++;
		return true;
	}

	@Override
	public E peek() {
		return size == 0 ? null : data[front];
	}

	@Override
	public E poll() {
		if (size == 0) {
			return null;
		}
		
		E output = data[front];
		data[front] = null;
		front ++;
		size --;
		return output;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (E element : this.data) {
			if (element != null) {
				sb.append(element.toString());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		GenericArrayQueue<String> mQueue = new GenericArrayQueue<>();
		mQueue.add("1");
		mQueue.add("2");
		mQueue.add("3");
		mQueue.add("4");
		System.out.println("Samuel Test mQueue = " + mQueue);
		String obj = mQueue.poll();
		System.out.println("Samuel Test mQueue obj = " + obj);
		mQueue.offer("5"); // use offer() --- there is no exception when..., it will return false
		mQueue.offer("6");
		System.out.println("Samuel Test mQueue peek = " + mQueue.peek());
		System.out.println("Samuel Test mQueue = " + mQueue);
		
		//mQueue.add("7");// add vs offer();  use add() will throw one exception.
		
		mQueue.poll();
		mQueue.remove();
		mQueue.remove();
		System.out.println("Samuel Test mQueue = " + mQueue);
	}
}
