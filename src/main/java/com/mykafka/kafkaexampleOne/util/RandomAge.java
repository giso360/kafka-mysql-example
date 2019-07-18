package com.mykafka.kafkaexampleOne.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAge {

	private static final List<Integer> age = new ArrayList<>();

	static {
		for (int i = 0; i < 100; i++) {
			age.add(i);
		}
	}

	public static int getAge(){
		Random r = new Random();
		int k = r.nextInt(100);
		int myAge  = age.get(k);
		return myAge;
	}
}
