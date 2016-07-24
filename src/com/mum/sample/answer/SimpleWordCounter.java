package com.mum.sample.answer;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SimpleWordCounter {
	public static void main(String[] args) {
        try {
            File f = new File("/Users/Samuel/Java_EE/eclipse_workspace/LeetCode_Training/src/com/mum/sample/ciaFactBook2008.txt");
            Scanner sc;
            sc = new Scanner(f);
            // sc.useDelimiter("[^a-zA-Z']+");
            Map<String, Integer> wordCount = new TreeMap<String, Integer>();
            while(sc.hasNext()) {
                String word = sc.next();
                if(!wordCount.containsKey(word))
                    wordCount.put(word, 1);
                else
                    wordCount.put(word, wordCount.get(word) + 1);
            }
            
            // show results
            for(String word : wordCount.keySet())
                System.out.println(word + " " + wordCount.get(word));
            System.out.println("-------- total words count = " + wordCount.size());
        }
        catch(IOException e) {
        	e.printStackTrace();
            System.out.println("Unable to read from file.");
        }
    }
}
