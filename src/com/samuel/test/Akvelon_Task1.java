package com.samuel.test;

import java.util.HashSet;
import java.util.Set;

public class Akvelon_Task1 {

	public static void main(String[] args) {
		int[] A1 = {60,80,40};
		int[] B1 = {2,3,5};
		int M1 = 5;
		int X1 = 2;
		int Y1 = 200;
		
		System.out.println("Samuel Test solution1 = " + solution(A1, B1, M1, X1, Y1));
		
		int[] A2 = {40,40,100,80,20};
		int[] B2 = {3,3,2,2,3};
		int M2 = 3;
		int X2 = 5;
		int Y2 = 200;
		
		System.out.println("Samuel Test solution2 = " + solution(A2, B2, M2, X2, Y2));
	}

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        int times = 0;
        int i = 0;
        
        // use to save floor numbers
        Set<Integer> tempSet = new HashSet<>();
        while (B[B.length - 1] != M + 1) {
        	 int weightSum = 0;
             int count = 0;
             for (; i < A.length; i ++) {
             	if (weightSum + A[i] > Y || count > X - 1) {
             		// stop
             		break;
             	} else {
             		weightSum += A[i];
             		count ++;
             		tempSet.add(B[i]);
             	}
             }
          
             times += tempSet.size() + 1; // + 1 for the ground floor
             tempSet.clear();
             B[i - 1] = M + 1;// 'M + 1' is a flag to clear ArrayB
        }
        return times;
    }
}
