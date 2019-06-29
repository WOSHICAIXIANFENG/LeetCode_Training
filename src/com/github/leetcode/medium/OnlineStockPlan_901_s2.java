package com.github.leetcode.medium;

import java.util.Stack;

// https://zxi.mytechroad.com/blog/stack/leetcode-901-online-stock-span/
public class OnlineStockPlan_901_s2 {

	public static void main(String[] args) {
		StockSpanner2 obj = new StockSpanner2();
		System.out.println("Cai Test = " + obj.next(100));
		System.out.println("Cai Test = " + obj.next(80));
		System.out.println("Cai Test = " + obj.next(60));
		System.out.println("Cai Test = " + obj.next(70));
		System.out.println("Cai Test = " + obj.next(60));
		System.out.println("Cai Test = " + obj.next(75));
		System.out.println("Cai Test = " + obj.next(85));
	}
}
// There will be at most 10000 calls to StockSpanner.next per test case.
// So, Approach 1: Brute Force will Time Out --- 
// TC: next O(n).  SC: O(n)

// https://zxi.mytechroad.com/blog/stack/leetcode-901-online-stock-span/

// 113 ms, faster than 46.98% 

// Approach 3 : Monotonic Stack 
// Maintain a monotonic stack whose element are pairs of price, span, sorted by price from high to low
// (when user put a pair into stack, you can eat all previous pairs which price is < current price)
// TC: ~O(1)
// O(1) amortized, each element will be pushed on to stack once, and pop at most once.

// SC: O(n)
// in the worst case, the prices is in descending order.

class StockSpanner2 {
	private Stack<Pair> stack;
	
    public StockSpanner2() {
    	this.stack = new Stack<>();
    }
    
    public int next(int price) {
    	Pair pair = new Pair(price);
    	if (stack.isEmpty() || price < stack.peek().price) {
    		pair.span = 1;
    	} else {
    		// Eat all the pre elements with lower price, add the span value to myself
    		int spanSum = 1;//!!! here is 1
    		while (!stack.isEmpty() && price >= stack.peek().price) { //!!! Don't forget to check if the stack is empty
    			spanSum += stack.pop().span;
    		}
    		pair.span = spanSum;
    	}
    	stack.push(pair);
    	return pair.span;
    }
    
    class Pair {
    	int price;
    	int span;
    	public Pair(int price) {
    		this.price = price;
    	}
    	public Pair(int price, int span) {
    		this.price = price;
    		this.span = span;
    	}
    }
}