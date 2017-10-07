package com.mm.sample;

/**
 * A class that represents a node to be used in a linked list.
 * @author Samuel
 *
 */
public class ListNode {
	private Object myData;// the data to store in this node.
	
	private ListNode myNext;// the link to the next node (presumably in a list)
	
	public ListNode() {
		this(null, null);
	}
	
	/**
	 * create a ListNode that holds the specified data and refers to the specified next element.
	 * pre: none<br>
	 * post: 
	 * @param data
	 * @param next
	 */
	public ListNode(Object data, ListNode next) {
		this.myData = data;
		this.myNext = next;
	}

	// return the data in this node
	public Object getMyData() {
		return myData;
	}

	// set the data in this node
	public void setMyData(Object myData) {
		this.myData = myData;
	}

	// return the ListNode this ListNode refers to
	public ListNode getMyNext() {
		return myNext;
	}

	// set the next node this ListNode refers to
	public void setMyNext(ListNode myNext) {
		this.myNext = myNext;
	}
	
	
}
