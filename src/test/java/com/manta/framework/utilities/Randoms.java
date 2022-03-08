package com.manta.framework.utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Randoms {

	/**
	 * To get the random number from 10000 to 99999
	 *
	 * @return Random Number
	 */
	public static int getRandomNumberBetween(int min, int max) {
		return new Random().nextInt(max - min) + min;
	}

	/**
	 * To get the random characters for given length
	 *
	 * @return Random Characters
	 */
	public static String getRandomCharacters(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

}
