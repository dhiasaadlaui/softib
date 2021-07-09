package com.softib.core.util;

import java.util.Random;

public class Utility {
	private static final int LEFT_LIMIT = 48;
	private static final int RIGHT_LIMIT = 122;
	private static final int ACTIVATION_KEY_LENGTH = 10;

	public static String generateActivationKey() {
		Random random = new Random();
		String generatedString = random.ints(LEFT_LIMIT, RIGHT_LIMIT + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(ACTIVATION_KEY_LENGTH)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

}
