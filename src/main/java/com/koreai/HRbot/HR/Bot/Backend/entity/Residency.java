package com.koreai.HRbot.HR.Bot.Backend.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Residency {

	private static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList("UsCitizen", "PermanentResident", "InternationalResident"));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static String randomEducationLevel() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
