package com.samuel.test;

import java.util.HashMap;

public class FindFirstRptChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "hrizonooor";
        Character result = getCharacter(input);
        if(result!=null){
            System.out.println("First Repeating Character in '"+input+"' is: " + result);
        }else{
            System.out.println("No Repeating Character found");
        }
	}

	
	 public static Character getCharacter(String input){
	     String str = input.replaceAll(" ", "");
	     Character rptChar = null;
	     
	     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	     for (char ch : str.toCharArray()) {
	       if (map.containsKey(ch)) {
	         map.put(ch, map.get(ch) + 1);
	        
	       } else {
	         map.put(ch, 1);
	       }
	     }
	    
	     for (char ch : str.toCharArray()) {
	       if (map.get(ch) > 1) {
	         rptChar = ch; 
	         break;
	       }
	     }
	    
	    return rptChar;
	  }
	 
}
