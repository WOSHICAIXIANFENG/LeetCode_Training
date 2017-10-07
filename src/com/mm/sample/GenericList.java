package com.mm.sample;

/**
 * A class to provide a simple List. List resizes automatically. Used to
 * illustrate various design and implementation details of a class in Java.
 * 
 * @author Samuel
 */
public class GenericList {
	// class constant for default size
	private static final int DEFAULT_CAP = 10;

	// instance variables
	// iValues store the elements of the list and
	// may have extra capacity
	private Object[] iValues;
	private int iSize;

	public void add(Object x) {
		insert(iSize, x);
	}

	public Object get(int pos) {
		return iValues[pos];
	}

	/**
	 * Insert obj at position pos.
	 * post: get(pos) = x, size() = old size() + 1
	 *
	 * @param pos 0 <= pos <= size()
	 * @param obj The element to add.
	 */
	public void insert(int pos, Object obj) {
		ensureCapacity();
		
		// error: think again
//		for(int i = pos; i < iSize; i ++)
//			iValues[i + 1] = iValues[i];
		
		for(int i = iSize; i > pos; i--){
            iValues[i] = iValues[i - 1];
        }
		
		iValues[pos] = obj;
		iSize ++;
	}

	public Object remove(int pos) {
		Object removeObj = iValues[pos];
		for (int i = pos; i < iSize; i ++) {
			iValues[pos] = iValues[pos + 1];
		}
		
		iSize --;
		
		return removeObj;
	}

	private void ensureCapacity() {
		if (iSize == iValues.length) {
			resize();
		}
	}

	public int size() {
		return iSize;
	}

	// resize internal storage container by a factor of 2
	private void resize() {
		Object[] newContainer = new Object[iValues.length * 2];
		System.arraycopy(iValues, 0, newContainer, 0, iSize);
		iValues = newContainer;
	}

	/**
	 * Return a String version of this list. Size and elements included.
	 */
	public String toString() {
		// we could make this more effecient by using a StringBuffer.
		// See alternative version
		String result = "size: " + iSize + ", elements: [";
		for (int i = 0; i < iSize - 1; i++)
			result += iValues[i].toString() + ", ";
		if (iSize > 0)
			result += iValues[iSize - 1];
		result += "]";
		return result;
	}

	// Would not really have this and toString available
	// both included just for testing
	public String toStringUsingStringBuffer() {
		StringBuffer result = new StringBuffer();
		result.append("size: ");
		result.append(iSize);
		result.append(", elements: [");
		for (int i = 0; i < iSize - 1; i++) {
			result.append(iValues[i]);
			result.append(", ");
		}
		if (iSize > 0)
			result.append(iValues[iSize - 1]);
		result.append("]");
		return result.toString();
	}

	/**
	 * Default constructor. Creates an empty list.
	 */
	public GenericList() {
		// redirect to single int constructor
		this(DEFAULT_CAP);
		// other statments could go here.
	}

	/**
	 * Constructor to allow user of class to specify initial capacity in case
	 * they intend to add a lot of elements to new list. Creates an empty list.
	 * 
	 * @param initialCap
	 *           > 0
	 */
	public GenericList(int initialCap) {
		iValues = new Object[initialCap];
		iSize = 0;
	}

	public static void main(String[] args) {
		GenericList list = new GenericList();
		list.add("samuel");
		list.add("add");
		list.add("mum");
		
		list.add("samuel");
		list.add("add");
		list.add("mum");
		
		list.add("samuel");
		list.add("add");
		list.add("mum");
		
		System.out.println("Samuel test 00000 list.size " + list.size() + " list = " + list.toString());
		
		list.insert(3, "xx");
		
		System.out.println("Samuel test 00000 list.size " + list.size()  + " list = " + list.toString());
		
		list.remove(4);
		
		System.out.println("Samuel test 00000 list.size " + list.size()  + " list = " + list.toString());
	}

}
