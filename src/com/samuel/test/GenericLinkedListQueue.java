package com.samuel.test;

import java.util.NoSuchElementException;

public class GenericLinkedListQueue<E> implements QueueInterface<E> {
	private Node<E> first, last;
	
	private static class Node<E> {
		private E data;
		
		private Node<E> next;
		
		public Node(E element) {
			data = element;
		}
	}

	@Override
	public QueueInterface<E> add(E element) {
		Node<E> node = new Node<E>(element);
		if (first == null) {
			first = node;
		} else {
			if (first.next == null) {
				first.next = node;
			} else {
				last.next = node;
			}
		}
		
		last = node;
		return this;
	}

	@Override
	public E element() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException("Queue does not contain any items.");
		}
		return first.data;
	}

	@Override
	public E remove() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException("Queue does not contain any items.");
		}
		
		E result = first.data;
		first = first.next;
		return result;
	}

	@Override
	public boolean offer(E element) {
		// return false if we run out of VM memory.
		add(element);
		return true;
	}

	@Override
	public E peek() {
		return first == null ? null : first.data;
	}

	@Override
	public E poll() {
		if (first == null) {
			return null;
		}
		
		E output = first.data;
		first = first.next;
		return output;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node start = first;
		while (start.next != null) {
			sb.append(start.data.toString() + " --> ");
			start = start.next;
		}
		sb.append(start.data.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		GenericLinkedListQueue<String> mQueue = new GenericLinkedListQueue<>();
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
		
		mQueue.add("7");// add vs offer();  use add() will throw one exception.
		
		mQueue.poll();
		mQueue.remove();
		mQueue.remove();
		System.out.println("Samuel Test mQueue = " + mQueue);
	}

}
