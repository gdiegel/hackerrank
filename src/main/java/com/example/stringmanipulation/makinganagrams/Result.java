package com.example.stringmanipulation.makinganagrams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private static final List<Character> ALPHABET = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    public static int makeAnagram(String a, String b) {
        final int sum = calculateFrequencies(a, b).values().stream().reduce(Integer::sum).orElse(0);
        return a.length() + b.length() - 2 * sum;
    }

    private static Map<Character, Integer> calculateFrequencies(String a, String b) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        ALPHABET.forEach(currentChar -> {
            final int occurencesInA = countOccurences(a, currentChar);
            final int occurencesInB = countOccurences(b, currentChar);
            final int lesserOccurence = Math.min(occurencesInA, occurencesInB);
            frequencies.put(currentChar, lesserOccurence);
        });
        return frequencies;
    }

    private static int countOccurences(String a, char b) {
        return Math.toIntExact(a.chars().filter(value -> value == b).count());
    }
}