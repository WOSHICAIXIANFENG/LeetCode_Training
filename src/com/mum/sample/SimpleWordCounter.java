package com.mum.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Program that compares counting words in files using an ArrayList and a Map
 * 
 * @author Samuel
 */
public class SimpleWordCounter {

	public static void main(String[] args) {
		File myFile = new File("/Users/Samuel/Java_EE/eclipse_workspace/LeetCode_Training/src/com/mum/sample/ciaFactBook2008.txt");
		try {
			Scanner sc = new Scanner(myFile);
			Map<String, Integer> words = new TreeMap<String, Integer>();
			while(sc.hasNext()) {
				String word = sc.next();
				if (words.containsKey(word)) {
					words.put(word, words.get(word).intValue() + 1);
				} else {
					words.put(word, 1);
				}
			}
			
			for (String a : words.keySet()) {
				System.out.println(a + " ---- " + words.get(a));
			}
			
			System.out.println("------------ total word count = " + words.keySet().size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("We can't access this file or the file is not readable");
		}
		
	}

}
