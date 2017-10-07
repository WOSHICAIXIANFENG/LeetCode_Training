package com.samuel.test;

import java.util.LinkedList;
import java.util.Queue;

public class MyGenericQueue<E> {
	private LinkedList<E> list;
	
	public MyGenericQueue() {
		this.list = new LinkedList<>();
	}
	
	public void enqueue(E item) {
		this.list.addLast(item);
	}
	
	public E dequeue() {
		return this.list.poll();
	}
	
	public int size() {
		return this.size();
	}
	
	public boolean hasItems() {
		return !list.isEmpty();
	}
	
	public void addItems(MyGenericQueue<? extends E> q) {
		while (q.hasItems()) {
			list.addLast(q.dequeue());
		}
	}
	
	@Override
	public String toString() {
		return list.toString();
	}

	public static void main(String[] args) {
		//Queue<String> mQueue = new Queue<>();
		MyGenericQueue<String> mQueue = new MyGenericQueue<>();
		mQueue.enqueue("1");
		mQueue.enqueue("2");
		mQueue.enqueue("3");
		mQueue.enqueue("4");
		System.out.println("Samuel Test mQueue = " + mQueue);
		
		mQueue.dequeue();
		System.out.println("Samuel Test mQueue = " + mQueue);
	}

}
