package com.samuel.test;

import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExample {

	public static void main(String[] args) {
		// hh:mm:ss:zzz
		LocalTime time = LocalTime.now();
		System.out.println("Current Time = " + time);
		
		LocalTime specificTime = LocalTime.of(12,20,25,40);
		System.out.println("Specific Time of Day = " + specificTime);
		
		LocalTime todayChina = LocalTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println("Current Time in China = " + todayChina);
		
		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
		System.out.println("10000th second time = " + specificSecondTime);
		
	}

}
