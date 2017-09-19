package com.github.leetcode.easy;

/**
 *
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
	An empty string is also valid.
 * @author Samuel
 *
 */
public class ValidParenthesisStr_678 {

	public static void main(String[] args) {
		String t1 = "()";
		String t2 = "(*)";
		String t3 = "(*)*)";
		String t4 = "(((((";
		
		System.out.println("Samuel Test checkValidString = " + checkValidString(t1));
		System.out.println("Samuel Test checkValidString = " + checkValidString(t2));
		System.out.println("Samuel Test checkValidString = " + checkValidString(t3));
		System.out.println("Samuel Test checkValidString = " + checkValidString(t4));
	}
	
	/**
	 * Complexity Analysis
	 * Time Complexity: O(N), where N is the length of the string. We iterate through the string once.
	 * Space Complexity: O(1), the space used by our lo and hi pointers. However, creating a new character array will take O(N) space.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean checkValidString(String s) {
		int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            // the smallest possible number of open left after processing the current character in the string. 
            // think * is )
            lo += c == '(' ? 1 : -1;

            // the largest number of open left brackets after processing the current character in the string.
            // think * is (
            hi += c != ')' ? 1 : -1;
            
            if (hi < 0) {
                break;
            }
            
            lo = Math.max(lo, 0);
        }
        
        return lo == 0;
    }
}
