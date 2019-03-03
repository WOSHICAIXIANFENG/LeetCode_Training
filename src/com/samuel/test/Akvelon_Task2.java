package com.samuel.test;

import java.util.Arrays;

public class Akvelon_Task2 {

	public static void main(String[] args) {
		int[] A = {2,1};
		int[] B = {3,3};
		System.out.println("Samuel Test solution = " + solution(A,B));
		
		int[] A1 = {1,3,2,1};
		int[] B1 = {4,2,5,3,2};
		System.out.println("Samuel Test solution = " + solution(B1,A1));
		
		int[] A2 = {4};
		int[] B2 = {1000000000, 1000000000, 1, 2,3,4,5};
		
		System.out.println("Samuel Test solution = " + solution(B2,A2));
		
		int[] A3 = {5};
        int[] B3 = {1, 2, 3, 5, 6};
        System.out.println("Samuel Test solution = " + solution(A3,B3));
        
        int[] A4 = {5};
        int[] B4 = {1, 2, 3, 4, 6, 5};
        System.out.println("Samuel Test solution = " + solution(A4,B4));
	}

	static int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
        	// only change one line --- if (i < m - 1 && B[i] < A[k]) to while
        	while (i < m - 1 && B[i] < A[k]) 
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}
