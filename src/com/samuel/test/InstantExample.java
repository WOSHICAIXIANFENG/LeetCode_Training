package com.samuel.test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Instant class is used to work with machine readable time format, it stores date time in unix timestamp.
 * @author Samuel
 *
 */
public class InstantExample {

	public static void main(String[] args) {
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = " + timestamp);

		// Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time = " + specificTime);
	
		// Duration example
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println(thirtyDay);
		
		// We can't create generic array!!!
		//List<Integer>[] intList = new List<Integer>[5];
		
		// Generic doesn't support sub-typing because it will cause issues in achieving type safety.
		//List<Number> numbers = new ArrayList<Integer>();
		
	}

}
