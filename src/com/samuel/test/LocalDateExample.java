package com.samuel.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class LocalDateExample {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("Current Date = " + today);
		
		//Create LocalDate by providing input arguments
		LocalDate firstDay = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date = " + firstDay);
		
		LocalDate todayChina = LocalDate.now(ZoneId.of("Asia/Shanghai"));
		System.out.println("Current Date in China = " + todayChina);

		LocalDate hundredDay = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014 = " + hundredDay);
	}

}
