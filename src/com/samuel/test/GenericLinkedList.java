package com.samuel.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class GenericLinkedList<E> implements Iterable<E> {
	transient Node<E> first;
	transient Node<E> last;
	 
	private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<E> {
		private Node curr;
		
		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public E next() {
//			E element = curr.item;
//			curr = curr.next;
//			return element;
			return null;
		}
	}
	
//	public boolean add(E e) {
//	    addBefore(e, header);
//	        return true;
//	}
	
//	private Entry<E> addBefore(E e, Entry<E> entry) {
//        //利用Entry构造函数构建一个新节点 newEntry，
//        Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
//        //修改newEntry的前后节点的引用，确保其链表的引用关系是正确的
//        newEntry.previous.next = newEntry;
//        newEntry.next.previous = newEntry;
//        //容量+1
//        size++;
//        //修改次数+1
//        modCount++;
//        return newEntry;
//    }

	/**
     * 返回指定位置(若存在)的节点元素
     */
//    private Entry<E> entry(int index) {
//        if (index < 0 || index >= size)
//            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
//                    + size);
//        //头部节点
//        Entry<E> e = header;
//        //判断遍历的方向
//        if (index < (size >> 1)) {
//            for (int i = 0; i <= index; i++)
//                e = e.next;
//        } else {
//            for (int i = size; i > index; i--)
//                e = e.previous;
//        }
//        return e;
//    }
    
    public void add(int index, E element){
    	
    }
    
    // == addLast();
    public boolean add(E e) {
       
        return true;
    }
    
    public void addFirst(E e) {
    	
    }
    public void addLast(E e) {
    	
    }
    public boolean remove(Object o) {
    	return true;
    }
    
//    public E get(int index) {
//        checkElementIndex(index);
//        return node(index).item;
//    }
    
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }
    
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }
    
//    public E removeFirst() {
//        final Node<E> f = first;
//        if (f == null)
//            throw new NoSuchElementException();
//        return unlinkFirst(f);
//    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
//    public E removeLast() {
//        final Node<E> l = last;
//        if (l == null)
//            throw new NoSuchElementException();
//        return unlinkLast(l);
//    }
//    
//    public boolean addAll(Collection<? extends E> c) {
//        return addAll(size, c);
//    }
    
//    public E set(int index, E element) {
//    	
//    }
//	
//    public void add(int index, E element) {
//    	
//    }
//    
//    public E remove(int index) {
//    	
//    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> orign = new LinkedList<>();
	}
}
