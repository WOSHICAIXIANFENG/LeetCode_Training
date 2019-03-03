package com.samuel.test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * develop the stack that also have min() method
   you have plenty of memory to solve the problem
   provide your approach

   push pop peek (optional) min() ------- all operation is O(1)
 * @author Samuel
 *
 * @param <T>
 */
public class MyGenericStack3<T extends Comparable<T>> {
	private List<T> data;
	private List<T> minStack;
	private T minElement;
	
	public MyGenericStack3() {
		this.data = new ArrayList<T>();
		this.minStack = new ArrayList<T>();
	}
	
	// 3,4,2,6,5,1 ---- dataStack
	// 3,3,2,2,2,1 ---- minStack
	public T push(T obj) {
		if (this.minStack.isEmpty()) {
			this.minStack.add(obj);
			this.minElement = obj;
		} else {
			if (minElement.compareTo(obj) < 0 ) {
				this.minStack.add(minElement);
			} else {
				this.minStack.add(obj);
				this.minElement = obj;
			}
		}
		
		data.add(obj);
		return obj;
	}
	
	public synchronized T pop() {
		if (data.isEmpty()) {
			throw new EmptyStackException();
		} else {
			// handle minStack
			minStack.remove(minStack.size() - 1);
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
	
	public synchronized T getMin() {
		if (data.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return this.minStack.get(data.size() - 1);
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
		MyGenericStack3<String> mStack = new MyGenericStack3<>();
//		mStack.push("1");
//		mStack.push("2");
//		mStack.push("3");
//		mStack.push("4");
//		System.out.println("Samuel Test mStack = " + mStack);
//		
//		mStack.push("5");
//		mStack.push("6");
//		mStack.push("7");
//		System.out.println("Samuel Test mStack = " + mStack);
//		System.out.println("Samuel Test mStack.size = " + mStack.size());
//		
//		String el = mStack.pop();
//		System.out.println("Samuel Test mStack pop el = " + el);
//		el = mStack.peek();
//		System.out.println("Samuel Test mStack peek el = " + el);
//		System.out.println("Samuel Test mStack.size = " + mStack.size());
//		
//		System.out.println("Samuel Test mStack search 6= " + mStack.search("6"));
//		System.out.println("Samuel Test mStack search 8= " + mStack.search("8"));
//		System.out.println("Samuel Test mStack search 5= " + mStack.search("5"));
		
		// Test min() method ---- 
		mStack.push("3");
		mStack.push("4");
		mStack.push("2");
		mStack.push("6");
		mStack.push("5");
		mStack.push("1");
		System.out.println("Samuel Test mStack = " + mStack);
		
		System.out.println("Samuel Test mStack minimum = " + mStack.getMin());
		mStack.pop();
		mStack.peek();
		System.out.println("Samuel Test mStack minimum = " + mStack.getMin());
		
	}

}
