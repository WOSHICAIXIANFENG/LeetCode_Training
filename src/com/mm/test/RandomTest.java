package com.mm.test;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		int quizeSize = 10;
		System.out.println(" random = " + random.nextInt(quizeSize)); //[0, quizeSize)
	}

}
