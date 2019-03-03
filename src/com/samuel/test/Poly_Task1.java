package com.samuel.test;

/**
 * 
A string contains a mathematical expression.  Please write a function to print the content enclosed by the first parenthesis pair in the string.  The first parenthesis pair is the first left parenthesis and its corresponding right parenthesis.

Example:  
For string:　“1 + 2 * ((3 / (5 – 2)) + 3 + (4 + 5))”
Print:  	        “((3 / (5 – 2)) + 3 + (4 + 5))”

 * @author Samuel
 *
 */
public class Poly_Task1 {

	public static void main(String[] args) {
		String str1 = "1 + 2 * ((3 / (5 – 2)) + 3 + (4 + 5))";
		
		System.out.println("Samuel Test  PrintFirstParenthesisPair = " + PrintFirstParenthesisPair(str1));
	}
	
	static String PrintFirstParenthesisPair(String str) {
	  	int leftIndex = str.indexOf('('); // 4
	    if (leftIndex == -1)  return null; 
	    
	    int rightIndex1 = str.indexOf(')');// 12
	    if (rightIndex1 == -1) return null;
	    
	    String subStr = str.substring(leftIndex, rightIndex1); // --> ((3 / (5 – 2
	    // calculate how many '(' in this substring
	    int numbOfLeft = getNumbOfLeft(subStr, 1);// ignore the first one  // get 1,2
	    System.out.println("Samuel Test numbOfLeft = " + numbOfLeft);
	    
	    int rightIndex = rightIndex1;
	    while (numbOfLeft >= 0) { // !!! --- 不要漏了=
	    		rightIndex = str.indexOf(')', rightIndex + 1); // from 13 ---- get 14 ---> get 15
	    		numbOfLeft --;
	    }
	    
	    return str.substring(leftIndex, rightIndex + 1); // get subString from 4, 15+1 ----> get (3 / (5 – 2))
	}

	static int getNumbOfLeft(String str, int start) {
	  // ((3 / (5 – 2
	  System.out.println("Samuel Test str = " + str + " , start = " + start);
		
	  if (str.length() <= start) return -1;
	  
	  int count = 0;
	  int index = str.indexOf('(', start);
	  while (index > 0) {
	  	  count ++;
	      index = str.indexOf('(', index + 1);// !!! + 1
	  }
	  
	  return count;
	}

}


