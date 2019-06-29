package com.github.leetcode.easy_top100;

import java.util.Arrays;

public class ReorderLogFiles937_top19 {

	public static void main(String[] args) {
		ReorderLogFiles937_top19 obj = new ReorderLogFiles937_top19();
		String[] s1 = {
				"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
		};
		System.out.println("Cai Test = " + Arrays.toString(obj.reorderLogFiles(s1)));
	}

	/**
	 * 0 <= logs.length <= 100 3 <= logs[i].length <= 100
	 * 
	 */
	// 37 ms, faster than 31.44% 
	
	// Approach 1: Partition and sorting!!!
	// Approach 2: Custom sorting!!!
	// TC: O(nlgN)
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (l1, l2) -> {
			String[] split1 = l1.split(" ", 2);
			String[] split2 = l2.split(" ", 2);
			//System.out.println("Cai Test split1 = " + Arrays.toString(split1));
			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
			if (!isDigit1 && !isDigit2) {
				int tmp = split1[1].compareTo(split2[1]);
				if (tmp != 0) return tmp;
				return split1[0].compareTo(split2[0]);
			}
			
			return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
		});
		return logs;
	}
	
//	public String[] reorderLogFiles(String[] logs) {
//		Arrays.sort(logs, (log1, log2) -> {
//			String[] split1 = log1.split(" ", 2);
//			String[] split2 = log2.split(" ", 2);
//			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
//			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
//			if (!isDigit1 && !isDigit2) {
//				int cmp = split1[1].compareTo(split2[1]);
//				if (cmp != 0)
//					return cmp;
//				return split1[0].compareTo(split2[0]);
//			}
//			return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
//		});
//		return logs;
//	}
}
