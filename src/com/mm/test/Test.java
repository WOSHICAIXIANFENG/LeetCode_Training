package com.mm.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
	   List<Integer> list = new ArrayList<Integer>();
       list.add(1);
       list.add(2);
       list.add(3);
    
       Iterator<Integer> iterator = list.iterator();
       while (iterator.hasNext()) {
    	   int i = (Integer) iterator.next();
    	   System.out.println(i);
       }

//		 m(9); 
	}
	
//	public static void m(int i) {
//		if (i == 1) {
//			System.out.println("1*1=1");
//		} else {
//			m(i - 1);
//			for (int j = 1; j <= i; j ++) {
//				System.out.print(j + "*" + i + "=" + j*i + " ");
//			}
//			System.out.println("");
//		}
//	}
}
