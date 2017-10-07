package com.samuel.test;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Implements a Stack, which is a data structure that works like a "line" ---- LIFO
 * @author Samuel
 *
 * @param <T>
 */
public class MyGenericStack2<T> {
	private static final int INIT_CAPACITY = 5;
	
	// can't create generic Array.
//	private T[] array = new T[INIT_CAPACITY];
	private Object[] data;
	private int top;
	
	public MyGenericStack2() {
		this.data = new Object[INIT_CAPACITY];
		this.top = 0;
	}
	
	public T push(T obj) {
		if (this.top >= data.length) {
			// extend the size for data array
			int size = data.length;
			Object[] temp = new Object[size * 2];
			System.arraycopy(data, 0, temp, 0, size);
			this.data = temp;
		}
		
		this.data[top] = obj;
		this.top ++;
		return obj;
	}
	
	public synchronized T pop() {
		if (this.top < 0) {
			throw new EmptyStackException();
		}
		
		T obj = peek();
		removeElementFromTop();
		return obj;
	}
	
	public synchronized void removeElementFromTop() {
		this.data[this.top - 1] = null;
		this.top --;
	}
	
	public synchronized T peek() {
		if (this.top < 1) {
			throw new EmptyStackException();
		}
		
		return (T) this.data[this.top - 1];
	}
	
	public synchronized int size() {
        return this.top;
    }
	
	/**
	 * Returns the 1-based position where an object is on this stack.
	 * returns the distance from the top of the stack of the
     * occurrence nearest the top of the stack
     * 
	 * @param o
	 * @return
	 */
	public synchronized int search(Object o) {
		if (this.top == 0) {
			return -1;
		}
		
		// loop the array to find the index 
		for (int i = this.top - 1; i >= 0; i --) {
			if (o.equals(this.data[i])) {
				return this.top - i;
			}
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Object obj : this.data) {
			if (obj != null) {
				sb.append(obj.toString() + ",");
			}
		}
		return "MyGenericStack [data=" + sb.toString().substring(0, sb.toString().length() - 1) + "]";
	}
	
	public static void main(String[] args) {	
		//Stack<String> mStack = new Stack<>();
		MyGenericStack2<String> mStack = new MyGenericStack2<>();
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
