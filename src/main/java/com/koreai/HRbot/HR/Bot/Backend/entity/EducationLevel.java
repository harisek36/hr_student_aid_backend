package com.koreai.HRbot.HR.Bot.Backend.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EducationLevel {
	private static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList("GraduateStudent", "UnderGraduateStudent"));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static String randomEducationLevel() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

}
