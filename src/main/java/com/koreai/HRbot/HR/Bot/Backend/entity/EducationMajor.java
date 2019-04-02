package com.koreai.HRbot.HR.Bot.Backend.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EducationMajor {
	private static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList("Engineering", "Finance", "Literature", "Management", "Arts and Design", null, ""));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static String randomEducationMajor() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

}
