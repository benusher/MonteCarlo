package com.iskido.montecarlo;

import java.util.Random;

public class RandomDataFixtures {

    private static final Random random = new Random();

    public static String someString() {
       return someStringOfLength(someNumberBetween(8, 12));
    }

    public static String someStringOfLength(int length) {
        String someString = "";

        for (int i = 0; i < length; i++) {
            someString += someCapitalLetter();
        }

        return someString;
    }

    public static String someCapitalLetter() {
        return String.valueOf((char) (random.nextInt(26) + 'A'));
    }

    public static int someNumberBetween(int inclusiveStart, int inclusiveEnd) {
        return random.nextInt(inclusiveEnd - inclusiveStart + 1) + inclusiveStart;
    }

    public static <T> T pickOneOf(T... choices) {
        return choices[random.nextInt(choices.length)];
    }
}
