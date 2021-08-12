package com.example.hashmaps.sherlockanagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.text.MessageFormat.format;

public class Result {

    public static int sherlockAndAnagrams(String s) {
        System.out.println(format("Original string: [{0}]", s));
        final char[] chars = s.toCharArray();

        Map<String, Integer> sortedSubStrings = new HashMap<>();
        for (int length = 1; length < chars.length; length++) {
            System.out.println(format("Length: [{0}]", length));
            for (int index = 0; index < chars.length; index++) {
                System.out.println(format("Index: [{0}]", index));
                if (index + length > chars.length) {
                    continue;
                }
                final String candidate = new String(Arrays.copyOfRange(chars, index, index + length));
                final String sortedCandidate = sortString(candidate);
                if (sortedSubStrings.containsKey(sortedCandidate)) {
                    sortedSubStrings.computeIfPresent(sortedCandidate, (key, val) -> val + 1);
                } else {
                    sortedSubStrings.put(sortedCandidate, 1);
                }
            }
            System.out.println(sortedSubStrings);
        }
        return sortedSubStrings.values()
                .stream()
                .filter(integer -> integer > 1)
                .map(Result::calculateNumberOfPossiblePairs)
                .reduce(Integer::sum).orElse(0);

    }

    private static int calculateNumberOfPossiblePairs(int n) {
        return (n * (n - 1)) / 2;
    }

    private static String sortString(String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
