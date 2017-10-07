package com.mm.sample;

import java.awt.Rectangle;
import java.util.Arrays;

public class CreateASet {
	public static void main(String[] args){
        String[] words = {"A", "B", "B", "D", "C", "A"};
        System.out.println( "original: " + Arrays.toString(words));
        System.out.println( "as a set: " + Arrays.toString(makeSet(words)));
        
        Rectangle[] rectList = {new Rectangle(), new Rectangle(), 
                    new Rectangle(0, 1, 2, 3), new Rectangle(0, 1, 2, 3)};
        System.out.println( "original: " + Arrays.toString(rectList));
        System.out.println( "as a set: " + Arrays.toString(makeSet(rectList)));     
        
        
        Object[] mixed = {"A", "C", "A", "B", new Rectangle(),
                new Rectangle(), "A", new Rectangle(0, 1, 2, 3), "D"};
        System.out.println( "original: " + Arrays.toString(mixed));
        System.out.println( "as a set: " + Arrays.toString(makeSet(mixed))); 
    }
    
    /**
     * An example of polymorphism in action. The method relies
     * on Java's inheritance requirement and polymorhphism to call
     * the correct equals method.
     * @param data != null, no elements of data are null
     * @return a Set (no duplicates) of the elements in data.
     */
    public static Object[] makeSet(Object[] data){
    	Object[] temp = new Object[data.length];
    	int uniquNum = 0;
    	for( int i = 0; i < data.length; i ++) {
    		boolean hasAdded = hasExistInFront(temp, uniquNum, data[i]);
    		if (hasAdded) {
    			continue;
    		} else {
    			temp[uniquNum] = data[i];
    			uniquNum ++;
    		}
    	}
    	
    	//System.out.println("Samuel Test create a set uniqueNum = " + uniquNum + " result = " + Arrays.toString(temp));
    	Object[] result = new Object[uniquNum];
        System.arraycopy(temp, 0, result, 0, uniquNum);
        
        return result;
    }
    
    private static boolean hasExistInFront(Object[] data, int index, Object value) {
    	for (int i = 0; i < index; i ++) {
    		if (data[i].equals(value)) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    private static boolean hasTheSameObj(Object[] data, int index) {
    	for (int i = 0; i < data.length  && i != index ; i ++ ) {
    		if (data[i].equals(data[index])) {
    			return false;
    		}
    	}
    	return true;
    }
}
