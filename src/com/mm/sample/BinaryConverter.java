package com.mm.sample;

public class BinaryConverter {

	public static void main(String[] args) {
		for (int i = -5; i < 33; i ++) {
			System.out.println(i + ":" + toBinary(i));
			// always another way
			System.out.println(i + ":" + Integer.toBinaryString(i));
		}
	}
	
	 /*
     * pre: none
     * post: returns a String with base10Num in base 2
     */
    public static String toBinary(int base10Num){
    	String result = "";
    	
    	boolean isNeg = base10Num < 0;
    	int num = isNeg ? Math.abs(base10Num) : base10Num;
   
    	while(num >= 2) {
    		result += num % 2;
    		num = num/2;
    	}
    	
    	result += num;
    	
    	// reverse the string     	
    	result = new StringBuilder(result).reverse().toString();
    	
    	if (isNeg) {
    		// 求原码
    		String yuanMa = "";
    		for (int i = 0; i < 32 - result.length(); i ++) {
    			yuanMa += "0";
    		}
    		yuanMa += result;
    		System.out.println("Samuel test   -base10Num 原码为 = " + yuanMa);
    		
    		// 求补码
    		String buMa = "";
    		char[] arrays = yuanMa.toCharArray();
    		for (int i = 0; i < 32; i ++) {
    			buMa += arrays[i] == '0' ? "1" : "0";
    		}
    		System.out.println("Samuel test   -base10Num 补码为 = " + buMa);
    		
    		// 补码加1
    		char[] buMaArray = buMa.toCharArray();
    		char[] finalArray = new char[32];
    		// 补码的最后一位是 0
    		if (buMaArray[31] == '0') {
				finalArray[31] = '1';
				for (int i = 30; i >= 0; i --) {
					finalArray[i] = buMaArray[i];
	    		}
			} else {
				//补码的最后一位是1
				finalArray[31] = '0';
				int i;
				for (i = 30; i >= 0; i --) {
					if (buMaArray[i] == '0') {
						finalArray[i] = '1';
						break;
					} else {
						finalArray[i] = '0';
					}
				}
				
				for (int j = i - 1; j >= 0; j --) {
					finalArray[j] = buMaArray[j];
				}
			}
    		
    		System.out.println("Samuel test   -base1补码 + 1 为 = " + new String(finalArray));
    		return new String(finalArray);
    	} else {
    		return result;
    	}
    }
    
    /*
     * pre: cal != null
     * post: return true if val consists only of characters 1 and 0, false otherwise
     */
    public static boolean all0sAnd1s(String val){
    	char[] chars = val.toCharArray();
    	for (char ch : chars) {
    		if (ch != '0' && ch != '1') {
    			return false;
    		}
    	}
    	return true;
    }

}
