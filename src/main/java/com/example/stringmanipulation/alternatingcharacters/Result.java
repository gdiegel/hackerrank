package com.example.stringmanipulation.alternatingcharacters;

public class Result {

    public static int alternatingCharacters(String s) {
        int numberOfDeletions = 0;
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                numberOfDeletions++;
            }
        }
        return numberOfDeletions;
    }

}