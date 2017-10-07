package com.samuel.test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Implements a Stack, which is a data structure that works like a "line" ---- LIFO
 * @author Samuel
 *
 * @param <T>
 */
public class MyGenericStack<T> {
	
	private List<T> data;
	
	public MyGenericStack() {
		this.data = new ArrayList<T>();
	}
	
	public T push(T obj) {
		data.add(obj);
		return obj;
	}
	
	public synchronized T pop() {
		if (data.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return data.remove(data.size() - 1);
		}
	}
	
	public synchronized T peek() {
		if (data.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return data.get(data.size() - 1);
		}
	}
	
	public synchronized int search(Object o) {
		if (data.size() == 0) {
			return -1;
		} else if (data.contains(o)) {
			return data.size() - data.indexOf(o);
		} else {
			return -1;
		}
	}
	
	public synchronized int size() {
		return data.size();
	}
	
	@Override
	public String toString() {
		return "MyGenericStack [data=" + data + "]";
	}
	
	public static void main(String[] args) {
		MyGenericStack<String> mStack = new MyGenericStack<>();
		mStack.push("1");
		mStack.push("2");
		mStack.push("3");
		mStack.push("4");
		System.out.println("Samuel Test mStack = " + mStack);
		
		mStack.push("5");
		mStack.push("6");
		mStack.push("7");
		System.out.println("Samuel Test mStack = " + mStack);
		System.out.println("Samuel Test mStack.size = " + mStack.size());
		
		String el = mStack.pop();
		System.out.println("Samuel Test mStack pop el = " + el);
		el = mStack.peek();
		System.out.println("Samuel Test mStack peek el = " + el);
		System.out.println("Samuel Test mStack.size = " + mStack.size());
		
		System.out.println("Samuel Test mStack search 6= " + mStack.search("6"));
		System.out.println("Samuel Test mStack search 8= " + mStack.search("8"));
		System.out.println("Samuel Test mStack search 5= " + mStack.search("5"));
	}

}
